/* 
* ECSE 321 Programming Assignment 2
* Winter 2015 
* 260590119
* Jenna Mar
* 
* This is the Subject class.
*/

import java.util.*;

public class Subject {

	private List<Observer> observers = new ArrayList<Observer>();

	public void attach(Observer observer){
		observers.add(observer);
	}

	public void remove(Observer observer){
		observers.remove(observer);
	}

	public void notifyAllObservers(){
		for (Observer observer : observers) {
			observer.update();
		}
	}
}