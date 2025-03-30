package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1003_피보나치함수 {
	
    static int T, N;
    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int[] result = count(N);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static int[] count(int n) {
        if (n < 0 || n > 40) {
            return new int[]{0, 0};
        }
        if (n == 0) return new int[]{1, 0};
        if (n == 1) return new int[]{0, 1};
        
        if (dp[n][0] != 0 || dp[n][1] != 0) return dp[n];

        int[] prev1 = count(n - 1);
        int[] prev2 = count(n - 2);

        dp[n][0] = prev1[0] + prev2[0];
        dp[n][1] = prev1[1] + prev2[1];

        return dp[n];
    }
}