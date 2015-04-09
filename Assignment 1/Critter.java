/*
* ECSE 321 Programming Assignment 1
* Winter 2015
* Jenna Mar
* 260590119
* This is the Critter class.
* It is not the class I am doing for this assignment,
* It is created here for testing purposes.
*/
import java.util.*;

public class Critter{

	protected LinkedList<Critter> critters = new LinkedList<Critter>();
	double pos_X;
	double pos_Y;
	double hp;
	double speed;

	public Critter(double x, double y){
		hp = 5;
		pos_X = x;
		pos_Y = y;
		speed = 1;
		addCritter();
	}

	public void addCritter(){
		critters.add(this);
	}
}