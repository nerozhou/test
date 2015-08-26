package design.pattern.observer;

import java.util.Observable;

public class Sheep extends Observable {
	public void change() {
		this.setChanged();
		this.notifyObservers();
	}
}
