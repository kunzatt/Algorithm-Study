package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12865_평범한배낭 {

    static int N, K, V;
    static int[] weight, value;
    static int[][] dp;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];
        weight = new int[N + 1];
        value = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (weight[i] <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        // LCS가 두 문자열을 행과 열로 2차원 배열로 표현하여 각 진행상황까지의 비교를 통해 LCS 길이를 저장해가며 해결하는 dp문제였다면,
        // 이 문제는 개수와 무게를 2차원 배열로 표현하여 주어진 개수 안에서 주어진 무게가 최대일때를 계속 저장해가며 새로운 물건이 들어왔을 때
        // 해당 단계에서 저장할 수 있는 최대 가치를 저장해가는 dp문제이다.

        System.out.println(dp[N][K]);
    }
}