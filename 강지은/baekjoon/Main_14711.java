import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14711 {
    
	static int N;
	static char[][] tile;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		tile = new char[N][N];
		visit = new boolean[N][N];
		
		tile[0] = br.readLine().toCharArray();
		
		for (int r = 0; r < N-1; r++) {
			for (int c = 0; c < N; c++) {
				if (tile[r][c]=='#') {
					flip(r,c);
				}				
			}
			
			for (int c = 0; c < N; c++) {
				if (visit[r][c]) tile[r+1][c]='#';
				else tile[r+1][c]='.';
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sb.append(tile[r][c]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void flip(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (!check(nr, nc)) continue;
			visit[nr][nc] = !visit[nr][nc];
		}
		
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}
}
