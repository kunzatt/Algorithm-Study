import java.io.*;
import java.util.*;

public class Main_1012 {
	
	static int T, N, M, K, count;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			count = 0;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);			
		}

	}

	static void dfs(int r, int c) {
		
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!check(nr, nc)) continue;
			if (!visited[nr][nc] && map[nr][nc] == 1) dfs(nr, nc);
		}
		
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
