import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012 {
	
	static int T;
	static int N, M, K;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visit = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			
			cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c]==1 && !visit[r][c])
						bfs(r,c);
				}
			}
			
			System.out.println(cnt);
			
		}		
	}

	private static void bfs(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r,c});
		visit[r][c] = true;
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (!check(nr, nc)) continue;
				if (visit[nr][nc] || map[nr][nc] < 1) continue;
				que.add(new int[] {nr,nc});
				visit[nr][nc] = true;
			}
		}
		cnt++;		
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}

}
