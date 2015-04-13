/*
* ECSE 321 Programming Assignment 3
* Winter 2015
* Jenna Mar
* 260590119
* This is the Strategy interface.
*/

import java.util.LinkedList;

interface Strategy {
	Critter target(LinkedList<Critter> inRange);
}

class Closest implements Strategy{
	
	Tower t;
	
	public Closest(Tower in){
		System.out.println("Targeting method of " + in.toString()  + " set to CLOSEST Critter.");
		t = in;
	}
	
	public Critter target(LinkedList<Critter> in){
		Critter closest = in.getFirst();
		
		for (Critter i : in){
			//find out which critter is the closest out of the critters in range
			//using the distance formula			
			if (Math.sqrt(Math.pow((i.position.getX() - t.position.getX()),2) + 
					Math.pow((i.position.getY() - t.position.getY()),2)) <= Math.sqrt(Math.pow((closest.position.getX() - 
					t.position.getX()),2) + Math.pow((closest.position.getY() - t.position.getY()),2))) { 				
				closest = i;
			}
		}
		return closest;
	}
}

class Farthest implements Strategy{
	
	Tower t;
	
	public Farthest(Tower in){
		System.out.println("Targeting method of " + in.toString()  + " set to FARTHEST Critter.");
		t = in;
	}
	
	public Critter target(LinkedList<Critter> in){
		Critter farthest = in.getFirst();
		
		for (Critter i : in){
			//find out which critter is the farthest out of the critters in range
			//using the distance formula			
			if (Math.sqrt(Math.pow((i.position.getX() - t.position.getX()),2) + 
					Math.pow((i.position.getY() - t.position.getY()),2)) >= 
					Math.sqrt(Math.pow((farthest.position.getX() - t.position.getX()),2) + 
					Math.pow((farthest.position.getY() - t.position.getY()),2))) { 				
				farthest = i;
			}
		}
		return farthest;
	}
}

class Strongest implements Strategy{
	
	Tower t;
	
	public Strongest(Tower in){
		System.out.println("Targeting method of " + in.toString()  + " set to STRONGEST Critter");
		t = in;
	}
	
	public Critter target(LinkedList<Critter> in){
		Critter strongest = in.getFirst();
		
		for (Critter i : in){
			//find out which critter is the strongest out of the critters in range		
			if (i.getHealth() >= strongest.getHealth()) { 				
				strongest = i;
			}
		}
		return strongest;
	}
}

class Weakest implements Strategy{
	
	Tower t;
	
	public Weakest(Tower in){
		System.out.println("Targeting method of " + in.toString()  + " set to WEAKEST Critter");
		t = in;
	}
	
	public Critter target(LinkedList<Critter> in){
		Critter weakest = in.getFirst();
		
		for (Critter i : in){
			//find out which critter is the weakest out of the critters in range		
			if (i.getHealth() <= weakest.getHealth()) { 				
				weakest = i;
			}
		}
		return weakest;
	}
}