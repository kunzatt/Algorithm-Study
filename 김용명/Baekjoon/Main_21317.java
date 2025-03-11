import java.io.*;
import java.util.*;

public class Main_21317 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] sarr = new int[N];
		int[] barr = new int[N];

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sarr[i] = Integer.parseInt(st.nextToken());
			barr[i] = Integer.parseInt(st.nextToken());
		}

		int K = Integer.parseInt(br.readLine());

		int[][] dp = new int[N][2];

		for (int i = 0; i < N; i++) {
			dp[i][0] = Integer.MAX_VALUE;
			dp[i][1] = Integer.MAX_VALUE;
		}

		dp[0][0] = 0;

		for (int i = 0; i < N - 1; i++) {
			if (dp[i][0] != Integer.MAX_VALUE) {
				if (i + 1 < N) {
					dp[i + 1][0] = Math.min(dp[i + 1][0], dp[i][0] + sarr[i]);
				}

				if (i + 2 < N) {
					dp[i + 2][0] = Math.min(dp[i + 2][0], dp[i][0] + barr[i]);
				}

				if (i + 3 < N) {
					dp[i + 3][1] = Math.min(dp[i + 3][1], dp[i][0] + K);
				}
			}

			if (dp[i][1] != Integer.MAX_VALUE) {
				if (i + 1 < N) {
					dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + sarr[i]);
				}

				if (i + 2 < N) {
					dp[i + 2][1] = Math.min(dp[i + 2][1], dp[i][1] + barr[i]);
				}
			}
		}
		int result = Math.min(dp[N - 1][0], dp[N - 1][1]);
		System.out.println(result);
	}
}