import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11403 {
    
	static int N;
	static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N];
        
        for (int r = 0; r < N; r++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				dp[r][c] = Integer.parseInt(st.nextToken());
			}
		}
        
        for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dp[i][k]==1 && dp[k][j]==1) {
						dp[i][j] = 1;							
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
