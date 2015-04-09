/*
ECSE 321 Programming Assignment 1
Winter 2015
Jenna Mar
260590119
*/

public class driver{
	public static void main(String[] args) {

		Tower testBasic = new NormalTower(2,3);
		Tower testFreezing = new FreezingTower(1,1); 
		Tower testMonster = new MonsterTower(5,5);
		
		System.out.println("Placed 3 towers.");
		
		Critter crit1 = new Critter(0,0);
		Critter crit2 = new Critter(6,8);

		System.out.println("Two critters have been deployed. Critter 1 has " + crit1.hp + 
			" health and critter 2 has " + crit2.hp + ".");

		testBasic.inRange(crit1.critters);
		testBasic.inRange(crit2.critters);

		System.out.println("The basic tower attacked the critters.");
		System.out.println("critter 1 now has a health value of " + crit1.hp + ".");
		System.out.println("critter 2 now has a health value of " + crit2.hp + ".\n");

		testFreezing.inRange(crit1.critters);
		testFreezing.inRange(crit2.critters);

		System.out.println("The freezing tower attacked the critters.");
		System.out.println("critter 1 now has a speed value of " + crit1.speed + ".");
		System.out.println("critter 2 now has a speed value of " + crit2.speed + ".\n");

		testMonster.inRange(crit1.critters);
		testMonster.inRange(crit2.critters);

		System.out.println("The heavy tower attacked the critters.");
		System.out.println("critter 1 now has a health value of " + crit1.hp + ".");
		System.out.println("critter 2 now has a health value of " + crit2.hp + ".\n");

		testBasic.sellTower(testBasic);
		testFreezing.increaseLevel();

		System.out.println("Freezing tower was upgraded, new fire rate is " + testFreezing.fireRate 
			+ " and selling value is " + testFreezing.value + ".");

	}
}