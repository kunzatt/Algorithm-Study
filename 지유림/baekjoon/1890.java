import java.io.*;
import java.util.*;

public class Main1890_점프 {
    static int N;
    static int[][] map;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        dp = new long[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                int num = map[i][j];

                if(num == 0) break;

                if(num+i <= N) dp[i+num][j] += dp[i][j];
                if(num+j <= N) dp[i][j+num] += dp[i][j];
            }
        }

        System.out.println(dp[N][N]);
    }
}
