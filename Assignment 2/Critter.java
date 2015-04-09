/*
* ECSE 321 Programming Assignment 2
* Winter 2015
* Jenna Mar
* 260590119
* This is the Critter class.
* It is not the class I am doing for this assignment,
* It is created here for testing purposes.
*/

//import java.util.*;
import java.awt.Point;

public class Critter{

	//protected LinkedList<Critter> critters = new LinkedList<Critter>();
	Point position;
	private int health;
	private double speed;

	public Critter(int x, int y){
		health = 5;
		position = new Point(x,y);
		speed = 1;
		//addCritter();
	}

	public int getHealth(){
		return health;
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public void setHealth(int hp){
		health = hp;
	}
	
	public void setSpeed(double sp){
		speed = sp;
	}
	
	public String HealthStatus(){
		if (this.health <= 0){
			return "is dead";
		}
		else {
			return "has health of " + String.valueOf(this.health);
		}
	}

	public String toString(){
		return("Critter at (" + this.position.getX() + ", " + this.position.getY() + ")");
	}

	/*public void addCritter(){
		critters.add(this);
	}*/
}