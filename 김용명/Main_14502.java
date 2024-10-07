import java.io.*;
import java.util.*;

public class Main_14502 {
	
	static int N, M, count, max;
	static boolean[][] visited;
	static int[][] map, fmap;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(max);

	}

	private static void dfs(int cnt) {
		
		if (cnt == 3) {			
			fmap = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					fmap[i][j] = map[i][j];
				}
			}
			
			visited = new boolean[N][M];
			count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (fmap[i][j] == 2)
					bfs(i, j);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (fmap[i][j] == 0) count++;
				}
			}
			
			max = Math.max(max, count);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt + 1);
					map[i][j] = 0;					
				}
			}
		}
		
	}

	static void bfs(int r, int c) {

		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r, c});
		visited[r][c] = true;
				
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int tr = temp[0];
			int tc = temp[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if(!check(nr, nc) || visited[nr][nc] || fmap[nr][nc] != 0) continue;
				visited[nr][nc] = true;
				fmap[nr][nc] = 2;
				que.add(new int[] {nr, nc});
			}
		}
		
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
