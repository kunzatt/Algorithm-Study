package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_11727_2n타일링2 {

	static int n;
	static long[] dp;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());        
        dp = new long[n + 1];
        
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 3;      

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }
        
        System.out.println(dp[n]);
    }
}