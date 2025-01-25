import java.io.*;
import java.util.*;

public class Main9084_동전 {
	static int T, N, M;
	static int[] coins;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			coins = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			dp = new int[M+1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(j-coins[i] > 0) {
						dp[j] = dp[j] + dp[j-coins[i]];
					} else if(j-coins[i] == 0) {
						dp[j]++;
					}
				}
			}
			sb.append(dp[M] + "\n");
		}

		System.out.println(sb.toString());
	}
}
