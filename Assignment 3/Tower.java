/*
* ECSE 321 Programming Assignment 3
* Winter 2015
* Jenna Mar
* 260590119
* This is the main Tower class.
*/

import java.awt.Point;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Tower{

	protected Point position;
	protected int size;
	protected int cost;
	protected int level;
	protected int value;
	protected int range;
	protected int bulletRange;
	protected double power;
	protected double fireRate;
	protected boolean isSpecial;
	protected double specialmod; //value determining amount of enemy attribute modification via special effects
	private Strategy targetmethod; //target strategy that the tower is using
	private String currmethod = "CLOSE";

	public Tower(Point input){
		position = input;
		this.initAttr();
		//default target method will be CLOSEST.
		targetmethod = new Closest(this);
	}

	//sell a specified tower
	public void sellTower(){
		Player.coins += value;
	}

	//initialize default attributes
	public void initAttr(){
		size = 1; //number of coord blocks tower takes up
		cost = 500; //buying cost
		level = 1; //upgrade level
		value = (int) (cost * 0.6); //selling value
		range = 3; //range of tower
		bulletRange = 1; //range of bullet explosion
		power = 1; //power of bullets
		fireRate = 1; //rate of fire
		isSpecial = false; //if tower has special effects
		specialmod = 1;	 //special effect value	
	}

	//increase the level of the tower
	public void increaseLevel(){
		if (Player.coins >= this.cost){
			
			cost += 120; //cost for next level
			value = (int) (cost * level * 0.6); //recalculate selling value
			fireRate *= 1.1;
			if (this.isSpecial == true){
				specialmod -= 0.05;
				range++;
			}
			else {
				power *= 1.5; //increase power, etc.
			}
			level++;
			Player.coins -= this.cost;
		}
		else {
			System.out.println("Insufficient funds. Upgrade of " + this.toString() + " failed.");
		}
	}

	//find critters in range and shoot at them
	//using the strategy as set.
	public void inRange(LinkedList<Critter> critters){
		LinkedList<Critter> inRangeCritters = new LinkedList<Critter>();

		//check entire list of critters to see if they're in range
		for (Critter i : critters){
			//use distance formula
			if (Math.sqrt((Math.pow(i.position.getX() - this.position.getX(),2)) + 
					Math.pow((i.position.getY() - this.position.getY()),2)) <= this.range){
				inRangeCritters.add(i);
			}
		}
				
		//target a critter in range using desired strategy
		try{
			Critter targeted = this.targetmethod.target(inRangeCritters);
			System.out.println("The targeted Critter was the " + targeted.toString());
			
			//damage targeted critter (i.e. fire a bullet at critter)
			//and inflict splash damage on other critters in range of the bullet
			for (Critter k : critters){			
				if (targeted != null && (k.position.getX() <= (targeted.position.getX() + this.bulletRange) && 
					k.position.getY() <= (targeted.position.getY() + this.bulletRange))){
					damage(k);
				}
			}
		}
		catch (NoSuchElementException e){
			System.out.println("No critters in range!");
		}
	}
	
	//inflict damage on enemy
	//if tower is special (slowing) type, change enemy speed
	public void damage(Critter enemy){
		if (this.isSpecial == false){
			enemy.setHealth((int) (enemy.getHealth() - this.power));
		}
		else {
			enemy.setSpeed(enemy.getSpeed() * specialmod);
		}		
	}
	
	public String toString(){
		return("Tower at (" + position.getX() + ", " + position.getY() + ")");
	}
	
	public boolean changeMethod(String in){
		if(!in.equalsIgnoreCase(currmethod)){
			if (in.equalsIgnoreCase("FAR")){
				targetmethod = new Farthest(this);
				currmethod = in;
				return true;
			}
			if(in.equalsIgnoreCase("CLOSE")){
				targetmethod = new Closest(this);
				currmethod = in;
				return true;
			}
			if(in.equalsIgnoreCase("WEAK")){
				targetmethod = new Weakest(this);
				currmethod = in;
				return true;
			}
			if(in.equalsIgnoreCase("STRONG")){
				targetmethod = new Strongest(this);
				currmethod = in;
				return true;
			}
			else {
				System.out.println("not a valid input.");
				return false;
			}
		}
		else {
			System.out.println("Tower is already set to that targeting method.");
			return false;
		}
	}
}