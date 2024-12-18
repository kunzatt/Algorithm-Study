import java.util.Scanner;

public class Main_9461 {
	static long[] dp = new long[101];
	static int T;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		
		for(int i=5; i<=100; i++) {
			dp[i] = dp[i-3] + dp[i-2];
		}
		
		T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();
			System.out.println(dp[N]);
		}
		
	}
}
