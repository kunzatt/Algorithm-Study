import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		
		while (true) {
			visit = new boolean[N][M];
			cnt = 0;
			boolean allMelt = true;
			
			// 바다를 -1로 변경 (중간에 바다가 되는 빙산과 구분하기 위함)
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 0) map[r][c] = -1;
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] > 0 && !visit[r][c]) {
						count(r,c);
						allMelt = false;
					}
				}
			}
		
			if (allMelt) {
				time = 0;
				break;
			}
			
			if (cnt >= 2) break;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] > 0) melt(r, c);
				}
			}
			
			time++;
		}
		
		System.out.println(time);
		
	}

	private static void melt(int r, int c) {
		int sea = 0;
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (!check(nr, nc)) continue;
			if (map[nr][nc] == -1) sea++;
		}
		
		map[r][c] -= sea;
		
		if (map[r][c] < 0) map[r][c] = 0;
	}

	private static void count(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r,c});
		visit[r][c] = true;
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (!check(nr, nc)) continue;
				if (map[nr][nc] < 0 || visit[nr][nc]) continue;
				que.add(new int[] {nr, nc});
				visit[nr][nc] = true;
			}
			
		}
		
		cnt++;
		
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}

}
