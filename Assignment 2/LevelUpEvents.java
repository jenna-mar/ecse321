/* 
* ECSE 321 Programming Assignment 2
* Winter 2015 
* 260590119
* Jenna Mar
* 
* This class gives update data when a tower's level is increased.
*/


public class LevelUpEvents implements Observer {

	private Tower observedTower;

	public LevelUpEvents(Tower observedTower) {
		super();
		this.observedTower = observedTower;
	}

	@Override
	public void update() {
		int newLevel = observedTower.level;
		int newCost = observedTower.cost;
		int newValue = observedTower.value;
		double newFireRate = observedTower.fireRate;
		
		System.out.println("The new level of the " + observedTower.toString() + " is: " + newLevel + ".");
		System.out.print("This means that the new ");
		
		//print special changed values if the tower has special properties
		if (observedTower.isSpecial){
			double newSpecial = observedTower.specialmod;
			int newRange = observedTower.range;
			System.out.print("range is " + newRange + ", the new slowing rate is " + newSpecial);
		}
		//otherwise, the tower's power is upgraded so print accordingly
		else {
			double newPower = observedTower.power;
			System.out.print("damaging power is " + newPower);
		}

		//print what has changed for all with the upgrade
		System.out.println(", the new cost is " + newCost + ", the new selling value is " + newValue + 
				", and the new fire rate is " + newFireRate + ".");
	}
}
