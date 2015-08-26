import java.util.Random;


public class HamingDistance {
	
	public static int N = 1000000000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(System.currentTimeMillis());
		long[] arrays = new long[1000];
		for (int i = 0; i < 1000; i++) {
			arrays[i] = rand.nextLong();
		}

		long fp1 = 0xFFFFFFFFFFFFFFFFL;
		long fp2 = 0XAFFFFFFFFFFFFFFFL;
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < N; i++) {
			isEqual2(arrays[i % 1000], arrays[(i+1) % 1000], 10);
		}
		
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static boolean isEqual(long fp1, long fp2, int n) {
		int count = 0;
		
		fp1 ^= fp2;
		while (fp1 != 0 && count < n) {
			fp1 &= fp2 - 1;
			count ++;
		}
		
		if (count < n) 
			return true;
		else 
			return false;
	}
	
	public static boolean isEqual2(long fp1, long fp2, int n) {
		long xor = fp1 ^ fp2;
		long val = 0;
		final long MASK = 0x0101010101010101L;
		
		for (int i = 0; i < 8; i++) {
			val += xor & MASK;
			xor >>>= 1;
		}
		
		val += val >>> 32;
		val += val >>> 16;
		val += val >>> 8;
		val &= 0xFF;
		
		if (val > n)
			return false;
		else 
			return true;
	}

}
