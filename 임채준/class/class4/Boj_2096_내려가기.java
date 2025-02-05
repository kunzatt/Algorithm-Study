package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2096_내려가기 {

    static int N, max, min;
    static int[][] map, dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][3];
        dp[0] = map[0];
        for(int i = 1; i < N; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    dp[i][j] = Math.max(map[i][j] + dp[i - 1][j], map[i][j] + dp[i - 1][j + 1]);
                } else if(j == 1){
                    dp[i][j] = Math.max((Math.max(map[i][j] + dp[i - 1][j - 1],map[i][j] + dp[i - 1][j])),map[i][j] + dp[i - 1][j + 1]);
                } else {
                    dp[i][j] = Math.max(map[i][j] + dp[i - 1][j - 1], map[i][j] + dp[i - 1][j]);
                }
            }
        }
        max = Math.max((Math.max(dp[N - 1][0], dp[N - 1][1])), dp[N - 1][2]);

        dp = new int[N][3];
        dp[0] = map[0];
        for(int i = 1; i < N; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    dp[i][j] = Math.min(map[i][j] + dp[i - 1][j], map[i][j] + dp[i - 1][j + 1]);
                } else if(j == 1){
                    dp[i][j] = Math.min((Math.min(map[i][j] + dp[i - 1][j - 1], map[i][j] + dp[i - 1][j])),map[i][j] + dp[i - 1][j + 1]);
                } else {
                    dp[i][j] = Math.min(map[i][j] + dp[i - 1][j - 1], map[i][j] + dp[i - 1][j]);
                }
            }
        }
        min = Math.min((Math.min(dp[N - 1][0], dp[N - 1][1])), dp[N - 1][2]);

        System.out.println(max + " " + min);

    }
}
