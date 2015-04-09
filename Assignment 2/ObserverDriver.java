/* 
* ECSE 321 Programming Assignment 2
* Winter 2015 
* 260590119
* Jenna Mar
* 
* This is the main Driver class. It will use the Observer.
*/

import java.util.*;

public class ObserverDriver {
	public static void main(String[] args) {

		//make a list of towers
		LinkedList<Tower> towers = new LinkedList<Tower>();
		
		//initialize player
		Player p1 = new Player("newplayer");

		//initialize/buy tower of each type
		NormalTower t1 = new NormalTower(2,2, towers);
		FreezingTower t2 = new FreezingTower(2,5, towers);
		MonsterTower t3 = new MonsterTower(6,6, towers);
		
		//create new observer and add
		LevelUpEvents l1 = new LevelUpEvents(t1);
		LevelUpEvents l2 = new LevelUpEvents(t2);
		LevelUpEvents l3 = new LevelUpEvents(t3);
		t1.attach(l1);
		t2.attach(l2);
		t3.attach(l3);
		
		//to test, increase level of each tower
		for (Tower i : towers){
			i.increaseLevel();
		}

		//further increase level of the normal tower...?
		t1.increaseLevel();
	}
}