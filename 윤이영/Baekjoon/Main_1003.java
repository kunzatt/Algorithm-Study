import java.util.Scanner;

// DP 중에서 바텀업 방식을 사용하여 풀이

public class Main_1003 {
	static int T;
	static int N;
	static int[] zero = new int[41];
	static int[] one = new int[41];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		zero[0] = 1;
		one[0] = 0;
		zero[1]=0;
		one[1]= 1;
		
		for(int i=2; i<=40; i++) {
			zero[i] = zero[i-1]+zero[i-2];
			one[i] = one[i-1] + one[i-2];
		}
		
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			System.out.println(zero[N]+" "+one[N]);
		}
		
	}
	
}
