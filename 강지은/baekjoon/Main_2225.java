import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2225 {

	static int N, K;
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new long[N+1][K+1];
		for (int i = 0; i < K+1; i++) {
			dp[0][i] = 1;
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < K+1; j++) {
				dp[i][j] = dp[i-1][j]+dp[i][j-1]%1000000000;
			}
		}
		
		System.out.println(dp[N][K]%1000000000);

	}

}
