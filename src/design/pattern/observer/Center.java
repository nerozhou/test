package design.pattern.observer;

public class Center {
	public static void main(String[] args)	{
		Observer1 o1 = new Observer1();
		Observer2 o2 = new Observer2();
		Sheep sheep = new Sheep();
		sheep.addObserver(o1);
		sheep.addObserver(o2);
		
		sheep.change();
	}
}
