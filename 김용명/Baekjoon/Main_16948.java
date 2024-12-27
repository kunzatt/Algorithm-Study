import java.io.*;
import java.util.*;

public class Main_16948 {
	
	static int N, count, r1, c1, r2, c2;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[N][N];
		visited = new boolean[N][N];
		count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		dist[r1][c1] = 0;
		bfs(r1, c1);
		if (dist[r2][c2] == 0) System.out.println(-1);
		else System.out.println(dist[r2][c2]);
		
	}

	static void bfs(int r, int c) {
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r, c});
		
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int tr = temp[0];
			int tc = temp[1];
			
			for (int i = 0; i < 6; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (!check(nr, nc) || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				dist[nr][nc] = dist[tr][tc] + 1;
				que.add(new int[] {nr, nc});
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
