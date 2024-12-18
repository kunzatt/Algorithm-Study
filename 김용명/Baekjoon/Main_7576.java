import java.io.*;
import java.util.*;

// 테크닉
// 1인 경우 동시에 bfs가 돌아야하기 때문에 일반적인 bfs처럼 하면 안되고 1인 경우를 먼저 큐에 넣어준 후 bfs를 돌려야한다.
public class Main_7576 {
	
	static int M, N, count;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<int[]> que = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		count = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					que.add(new int[] {i, j});		// 테크닉
				}
			}
		}
		
		System.out.println(bfs());

	}

	static int bfs() {
		
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			
			for (int d = 0; d < 4; d++) {				
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				
				if (!check(nr, nc)) continue;
				if (map[nr][nc] == 0) {
					// 상하좌우를 돌고 count를 해야하는데 count의 최댓값을 구하려면 bfs 경우의 수를 그냥 저장하고 최대값을 출력면 됨.
					map[nr][nc] = map[temp[0]][temp[1]] + 1; 		
					que.add(new int[] {nr, nc});
				}				
			}
		}
		
		int ans = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) ans = -1;
				max = Math.max(max, map[i][j]);
			}
		}
		
		if (ans != 0) return -1;
		else return max - 1;
		
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
