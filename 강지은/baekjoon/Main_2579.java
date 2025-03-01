import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2579 {

    static int N;
    static int[] dp;
    static int[] score;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        score = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            dp[i] = Integer.parseInt(br.readLine());
        }

        if (N==1) {
        	score[1] = dp[1];  	
        } else if (N==2) {
        	score[2] = dp[2] + dp[1];        	
        } else {
        	score[1] = dp[1];
        	score[2] = dp[2] + dp[1];
        	score[3] = Math.max(dp[3]+dp[1], dp[3]+dp[2]);
        	for (int i = 4; i < N + 1; i++) {
                score[i] = Math.max(score[i-3]+dp[i-1]+dp[i], score[i-2]+dp[i]);
                
            }
        }

        System.out.println(score[N]);

    }
}
