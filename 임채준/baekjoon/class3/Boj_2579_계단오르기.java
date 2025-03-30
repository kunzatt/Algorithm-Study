package class3;

import java.io.*;

public class Boj_2579_계단오르기 {
	
	static int N;
	static int[] stairs;
	static int[][] dp;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        
        dp = new int[N + 1][3];
        
        if (N >= 1) {
            dp[1][1] = stairs[1];
        }
        
        if (N >= 2) {
            dp[2][1] = stairs[2];
            dp[2][2] = stairs[1] + stairs[2];
        }
        
        for (int i = 3; i <= N; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + stairs[i];
            dp[i][2] = dp[i-1][1] + stairs[i];
        }
        
        System.out.println(Math.max(dp[N][1], dp[N][2]));
    }
}