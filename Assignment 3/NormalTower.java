/*
* ECSE 321 Programming Assignment 3
* Winter 2015
* Jenna Mar
* 260590119
*
* This class creates a basic Tower.
*/

import java.awt.Point;

public class NormalTower extends Tower{

	public NormalTower(Point in){
		super(in);
		//a tower was bought, so subtract coins
		Player.coins -= this.cost;
	}
	
	public String toString(){
		return("Basic Tower at (" + position.getX() + ", " + position.getY() + ")");
	}
}