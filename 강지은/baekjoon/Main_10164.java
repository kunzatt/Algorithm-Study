import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10164 {
    
	static int N, M, K, R, C;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken())-1;
        
        if (K==-1) {
        	R = N-1;
        	C = M-1;
        } else {
        	R = K/M;
            C = K%M;
        }
        
        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
			Arrays.fill(map[r], 1);
		}
        
        for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (r==0 || c==0) {
					continue;
				}
				
				if ((R<r && C>c) || (R>r && C<c)) {
					continue;
				}
				
				if ((R==r && C<c) || (R<r && C==c)) {
					continue;
				}
				
				map[r][c] = map[r-1][c]+map[r][c-1];
			}
		}
        
        if (K==-1) {
        	System.out.println(map[R][C]);
        } else {
        	System.out.println(map[R][C]*map[N-1][M-1]);        	
        }
        
    }

}
