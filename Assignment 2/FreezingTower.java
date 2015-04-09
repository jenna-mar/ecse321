/*
* ECSE 321 Programming Assignment 2
* Winter 2015
* Jenna Mar
* 260590119
*
* This class creates a Tower which inflicts a slowing effect.
*/

import java.util.*;

public class FreezingTower extends Tower{
	

	public FreezingTower(int x, int y, LinkedList<Tower> towers){
		super(x,y,towers);
		initAttr();
		//a tower was bought, so subtract coins
		Player.coins -= this.cost;
	}

	/*
	//buy a tower
	public void addTower(){
		towers.add(this);
	}
	*/

	public void initAttr(){
		size = 1; //size of tower
		cost = 150; //buying cost
		level = 1; //upgrade level
		value = (int) (cost * level * 0.6); //selling value
		range = 5; //range of tower
		bulletRange = 5; //range of bullet explosion
		power = 1; //power of bullets
		fireRate = 1; //rate of fire
		isSpecial = true; //if tower has special effects
		specialmod = 0.8; //rate of modification if tower is special type
	}
	
	public String toString(){
		return("freezing tower at (" + position.getX() + ", " + position.getY() + ")");
	}
}