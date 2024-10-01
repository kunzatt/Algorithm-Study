import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main_7576 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		Queue<int[]> que = new LinkedList<>();
		int tomato = 0; // 안 익은 토마토
		
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1) que.add(new int[] {r,c});
				if (map[r][c] == 0) tomato++;
			}
		}
		
		int day = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			
			for (int i = 0; i < size; i++) {
				int[] cur = que.poll();
				int r = cur[0];
				int c = cur[1];
				
				for (int d = 0; d < 4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					
					if (!check(nr, nc)) continue;
					if (map[nr][nc] == 0) {
						que.add(new int[] {nr,nc});
						map[nr][nc] = 1;
						tomato--;
					}
				}
			}
			
			day++;
		}
		
		if (tomato > 0) System.out.println(-1);
		else System.out.println(day-1);
		
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}

}
