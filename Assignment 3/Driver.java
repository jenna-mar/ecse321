/*
* ECSE 321 Programming Assignment 3
* Winter 2015
* Jenna Mar
* 260590119
* This is the main driver class.
* It will test different targeting methods used by the tower
* using the strategy design pattern.
*/


import java.awt.Point;
import java.util.LinkedList;
import java.util.Scanner;

class Driver {

	public static void main(String[] args){
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		
		//initialize new player for testing
		Player me = new Player("test");
		
		//initialize a tower.
		NormalTower testBasic = new NormalTower(new Point(5,5));
		FreezingTower testIce = new FreezingTower(new Point(15, 15));
		MonsterTower testMonster = new MonsterTower(new Point(0,0));
		
		System.out.println("Test with Basic Tower.");
		
		//make a list for the critters.
		LinkedList<Critter> critterlist = new LinkedList<Critter>();
				
		//initialize some critters.
		Critter close = new Critter(new Point(4,5), "CLOSE");
		Critter far = new Critter(new Point(7,7), "FAR");
		Critter weak = new Critter(new Point(3,4), "WEAK");
		Critter strong = new Critter(new Point(3,6), "STRONG");
		
		weak.setHealth(2);
		strong.setHealth(10);
		
		//add to the list.
		critterlist.add(close);
		critterlist.add(far);
		critterlist.add(weak);
		critterlist.add(strong);
		
		System.out.println("\n4 Critters have been initialized. They are: ");
		for (Critter c: critterlist){
			System.out.println("A " + c.toString());
		}
		
		System.out.println("Try shooting at the critters.");
		//shoot at the critters
		testBasic.inRange(critterlist);
		
		while (flag){
			System.out.println("Change method before tower shoots again? (Y/N or type EXIT)");
			String in = scanner.nextLine();
			if (in.equalsIgnoreCase("Y") || in.equalsIgnoreCase("YES")){
				System.out.println("Choose CLOSE, FAR, WEAK, or STRONG.");
				String s = scanner.nextLine();
				if (testBasic.changeMethod(s)){
					testBasic.inRange(critterlist);
				}				
			}
			else if (in.equalsIgnoreCase("N") || in.equalsIgnoreCase("NO")){
				System.out.println("Okay. The tower will shoot again with it's current setting...");
				testBasic.inRange(critterlist);
			}
			else if (in.equalsIgnoreCase("EXIT")){
				flag = false;
			}
			else {
				System.out.println("That wasn't a valid input.");
			}
		}
		
		/*
		//change method.
		testBasic.changeMethod("far");
		testBasic.inRange(critterlist);
		
		//change method.
		testBasic.changeMethod("weak");
		testBasic.inRange(critterlist);
		
		//change method.
		testBasic.changeMethod("strong");
		testBasic.inRange(critterlist);
		*/
	}
	
}
