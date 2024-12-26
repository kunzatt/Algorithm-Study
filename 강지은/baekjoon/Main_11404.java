import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404 {
    
	static int N, M;
	static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp = new int[N][N];
        
        for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			if (dp[a][b] > 0) {
				dp[a][b] = Math.min(dp[a][b], c);				
			} else {
				dp[a][b] = c;
			}
		}
        
        for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i==j) continue;
					if (dp[i][k] > 0 && dp[k][j] > 0) {
						if (dp[i][j] > 0) {
							dp[i][j] = Math.min(dp[i][k]+dp[k][j], dp[i][j]);							
						} else {
							dp[i][j] = dp[i][k]+dp[k][j];
						}
					}
				}
			}
		}
        
        for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(dp[r][c]+" ");
			}
			System.out.println();
		}
        
    }
    
}
