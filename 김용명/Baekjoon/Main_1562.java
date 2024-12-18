import java.io.*;

public class Main_1562 {
    static long ans;
    static int N, MOD;
    static long[][][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ans = 0;
        N = Integer.parseInt(br.readLine());
        MOD = 1000000000;
        dp = new long[N+1][10][1<<10]; 

        for (int i = 1; i <= 9; i++) {
        	dp[1][i][1<<i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for(int visited = 0; visited < (1<<10); visited++) {
                    int nvisited = (visited | (1<<j));
                    if(j == 0) dp[i][j][nvisited] += dp[i-1][j+1][visited]%MOD; 
                    else if(j == 9) dp[i][j][nvisited] += dp[i-1][j-1][visited]%MOD; 
                    else dp[i][j][nvisited] += (dp[i-1][j-1][visited]%MOD + dp[i-1][j+1][visited]%MOD);

                    dp[i][j][nvisited] %= MOD;
                }
            }
        }

        for (int i = 0; i <= 9; i++) { 
            ans += dp[N][i][(1<<10)-1]%MOD;
            ans %= MOD;
        }
        System.out.println(ans);
    }
}