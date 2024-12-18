import java.io.*;
import java.util.*;

public class Main_2468_dfs {
	
	static int N, max, count;
	static int[][] map, arr;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N+2][N+2];
		arr = new int[N+2][N+2];
		visited = new boolean[N+2][N+2];
		max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		for (int i = 0; i <= 100; i++) {		// 빌딩 전체 높이가 1인 경우를 생각해야한다. 그래서 i를 1이 아닌 0부터 시작해야한다.
			count = 0;
			
			for (int j = 0; j < N+2; j++) {
				for (int k = 0; k < N+2; k++) {
					arr[j][k] = map[j][k];
					visited[j][k] = false;
				}
			}
			
			Out : for (int j = 0; j < N+2; j++) {
				for (int k = 0; k < N+2; k++) {
					if (i == 0) break Out;		
					if (arr[j][k] <= i) {
						arr[j][k] = 0;
					}
				}
			}					
			
			for (int j = 0; j < N+2; j++) {
				for (int k = 0; k < N+2; k++) {
					if (arr[j][k] != 0 && !visited[j][k]) {
						dfs(j, k);
						count++;
					}
				}
			}
			
			max = Math.max(max, count);
		}
		
		System.out.println(max);

	}

	static void dfs(int r, int c) {
		
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (!check(nr, nc) || visited[nr][nc] || arr[nr][nc] == 0) continue;
			dfs(nr, nc);
		}
		
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N+2 && c < N+2;
	}

}
