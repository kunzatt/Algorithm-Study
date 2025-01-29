import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16493 {

    static int N, M;
    static int[][] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dp = new int[M+1][N+1];
        
        for (int i = 1; i < M+1; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int chapter = Integer.parseInt(st.nextToken());
			
			for (int j = 1; j < N+1; j++) {
				dp[i][j] = dp[i-1][j];
				if (j >= day) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-day]+chapter);
				}
			}
			
		}
        
        System.out.println(dp[M][N]);
        
    }
	
}
