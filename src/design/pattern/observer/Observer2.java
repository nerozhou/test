package design.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Observer2 implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.printf("Observing %s, I'm %s\n", o.toString(), this.getClass());
	}

}