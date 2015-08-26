
public class Goto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OUT_SIDE:
		for (int i = 0; i < 10; i++) {
			OUT_SIDE2:
			for(int j = 0; j < 11; j++)	 {
				if (i > 5) {
					System.out.println("i" + i + "j" + j);
					break OUT_SIDE2; 
				}
			}
			
			
		}
		System.out.println("OutSide");
	}

}
