package percombsub;

public class BitPower {
	
	static int[] p = {1, 2, 3, 4, 5};
	static int N;

	public static void main(String[] args) {
		
		N = p.length;
		for(int i = 0; i < (1 << N); i++) {
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					System.out.print(p[j] + " ");
				}
			}
			System.out.println();
			System.out.println("--------");
		}

	}

}
