import java.io.*;
import java.util.*;

public class Main_1149 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] dp = new int[N][3];
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp[i][j] = Math.min(dp[i-1][1]+arr[i][j], dp[i-1][2]+arr[i][j]);
				}else if (j == 1) {
					dp[i][j] = Math.min(dp[i-1][0]+arr[i][j], dp[i-1][2]+arr[i][j]);
				}else if (j == 2) {
					dp[i][j] = Math.min(dp[i-1][0]+arr[i][j], dp[i-1][1]+arr[i][j]);
				}
			}
		}
		
		int ans = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
		System.out.println(ans);

	}

}
