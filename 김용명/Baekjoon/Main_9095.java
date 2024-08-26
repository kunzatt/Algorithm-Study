import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] dp = new int[11];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			// dp[1] = 1
			// dp[2] = 1+1
			// dp[3] = 1+1+1, 1+2, 2+1, 3
			// dp[4] 는 dp[3]의 모든 경우의 수에서 +1을 한 경우 + dp[2]의 모든 경우의 수에서 +2을 한 경우=
			//         dp[1]의 모든 경우의 수에서 31을 한 경우 이다.
			// 따라서 dp[4] = dp[3] + dp[2] + dp[1] 이다.
			
			for (int i = 4; i < dp.length; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			System.out.println(dp[n]);
		}

	}

}
