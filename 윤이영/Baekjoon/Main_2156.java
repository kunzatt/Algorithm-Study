import java.util.Scanner;

public class Main_2156{
    static int N;
    static int[] wine;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        wine = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {  
            wine[i] = sc.nextInt();
        }


        if (N >= 1) dp[1] = wine[1];
        if (N >= 2) dp[2] = wine[1] + wine[2];

        
        // DP
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1],  // 이번 포도주를 마시지 않음
                    Math.max(dp[i - 2] + wine[i],  // 이전 포도주를 마시지 않음
                            dp[i - 3] + wine[i - 1] + wine[i]));  // 전전 포도주를 마시지 않음
        }

        System.out.println(dp[N]);  // 최댓값 출력
    }
}
