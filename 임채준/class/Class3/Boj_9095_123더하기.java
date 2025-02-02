package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_9095_123더하기 {
	
	static int T, N;
	static int[] dp;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	T = Integer.parseInt(br.readLine());
    	
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}