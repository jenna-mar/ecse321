/*
* ECSE 321 Programming Assignment 3
* Winter 2015
* Jenna Mar
* 260590119
*
* This class creates a large, heavy area of effect Tower.
*/

import java.awt.Point;

public class MonsterTower extends Tower{

	public MonsterTower(Point in){
		super(in);
		initAttr();
		//a tower was bought, so subtract coins
		Player.coins -= this.cost;
	}

	public void initAttr(){
		size = 2; //size of tower
		cost = 2000; //buying cost
		level = 1; //upgrade level
		value = (int) (cost * 0.6); //selling value
		range = 7; //range of tower
		bulletRange = 5; //range of bullet explosion
		power = 5; //power of bullets
		fireRate = 3; //rate of fire
		isSpecial = false; //if tower has special effects
		specialmod = 1;	
	}
	
	public String toString(){
		return("Monster Tower at (" + position.getX() + ", " + position.getY() + ")");
	}
}