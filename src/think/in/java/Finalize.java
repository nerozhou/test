package think.in.java;

public class Finalize {
	private boolean finalStatus;
	
	public Finalize() {
		finalStatus = false;
	}
	
	@Override
	public void finalize() {
		if (!finalStatus) {
			System.out.println("no final");
		}
	}
	
	public static void main(String[] args) {
		new Finalize();
		
		System.gc();
	}
}
