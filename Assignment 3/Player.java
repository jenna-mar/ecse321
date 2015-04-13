

/* 
* ECSE 321 Introduction to Software Engineering
* Winter 2015 
* Assignment 3
* 260590119
* Jenna Mar
* 
* This is a simple Player class made so that the Tower buying/selling may function.
*/

public class Player {
	
	private String username;
	public static int coins;
	
	public Player(String name){
		username = name;
		coins = 1800;
	}
}
