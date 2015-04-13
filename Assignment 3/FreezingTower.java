/*
* ECSE 321 Programming Assignment 3
* Winter 2015
* Jenna Mar
* 260590119
*
* This class creates a Tower which inflicts a slowing effect.
*/

import java.awt.Point;

public class FreezingTower extends Tower{
	
	public FreezingTower(Point in){
		super(in);
		initAttr();
		//a tower was bought, so subtract coins
		Player.coins -= this.cost;
	}

	public void initAttr(){
		size = 1; //size of tower
		cost = 1000; //buying cost
		level = 1; //upgrade level
		value = (int) (cost * 0.6); //selling value
		range = 5; //range of tower
		bulletRange = 5; //range of bullet explosion
		power = 1; //power of bullets
		fireRate = 1; //rate of fire
		isSpecial = true; //if tower has special effects
		specialmod = 0.8;	
	}
	
	public String toString(){
		return("Freezing Tower at (" + position.getX() + ", " + position.getY() + ")");
	}
}