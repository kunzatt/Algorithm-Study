import java.util.Scanner;

public class Main_14501 {
	static int N;
	static int[] T;
	static int[] P;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N+1];
		P = new int[N+1];
		dp = new int[N+1];
		
		for(int i=0; i<N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		
		for(int i=0; i<N; i++) {
			if( (i + T[i]) <= N) {	// 상담 완료 시점이 N일 이내여야 상담 진행 가능
				dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i]+P[i]);
			}
			dp[i+1]=Math.max(dp[i+1],dp[i]);
		}
		
		System.out.println(dp[N]);
	}
}
