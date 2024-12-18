import java.util.Arrays;
import java.util.Scanner;

public class Main_2839 {
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 3킬로그램, 5킬로그램
		N = sc.nextInt();
		dp = new int[N+1];
		Arrays.fill(dp,5000);
		
		if(N >= 3) {
			dp[3] = 1;
		}
		if(N >= 5) {
			dp[5] = 1;
		}
		
		for(int i=6; i<=N; i++) {
			if(dp[i-3] == 5000 && dp[i-5] == 5000) {
				continue;
			}
			dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
			//System.out.println(Arrays.toString(dp));
		}
		
		if(dp[N] == 5000) {
			System.out.println("-1");
		}
		else {
			System.out.println(dp[N]);
		}
	}
}
