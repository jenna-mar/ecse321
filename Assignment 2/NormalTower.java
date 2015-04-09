/*
* ECSE 321 Programming Assignment 2
* Winter 2015
* Jenna Mar
* 260590119
*
* This class creates a basic Tower.
*/

import java.util.*;

public class NormalTower extends Tower{
	

	public NormalTower(int x, int y, LinkedList<Tower> towers){
		super(x,y,towers);
		//a tower was bought, so subtract coins
		Player.coins -= this.cost;
	}
	/*
	//buy a tower
	public void addTower(){
		towers.add(this);
	}
	*/
	
	public String toString(){
		return("basic tower at (" + position.getX() + ", " + position.getY() + ")");
	}
}