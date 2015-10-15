package think.in.java;

public class Finalize {
	private boolean finalStatus;
	
	public Finalize() {
		finalStatus = false;
	}
	
	@Override
	public void finalize() {
		//if (!finalStatus) {
			System.out.println("no final");
		//}
	}
	
	public static void main(String[] args) {
		Finalize f = new Finalize();
		for (int a = 0; a < 10000; a++) {
			byte[] bytes = new byte[1024 * 100];
		}
		f = null;
		System.gc();
	}
}
