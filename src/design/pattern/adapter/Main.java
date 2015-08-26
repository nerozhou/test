package design.pattern.adapter;

public class Main {

	public static void main(String[] args) {
		/* 
		 * 类适配
		 * interface <-- adapter <-- classA
		 * 			  	|-extends classA
		 * 			  	|-implements interface
		 */
		Client c1 = new TimeAdapter();
		System.out.println(c1.getTime());
		
		/*
		 * 对象适配
		 * interface <-- [abstract] classA <-- adapter <-- classB
		 * 										|-extends [abstract] classA
		 * 										|-member instance of classB
		 */
		Client c2 = new TimeAdapter2(new TimeService());
		System.out.println(c2.getTime());
	}

}
