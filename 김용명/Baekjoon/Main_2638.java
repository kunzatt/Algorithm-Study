import java.io.*;
import java.util.*;

public class Main_2638 {
	
	static int N, M, count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		count = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			visited = new boolean[N][M];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sum += map[i][j];
				}
			}
			if (sum == 0) break;
			
			// 내부 공간을 바꾸려고 하면 어렵다.
			// 외부 공간을 그때그때마다 5로 바꾸면 내부 치즈는 무조건 0이 된다
			changeCheese(0, 0);		
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j])
					bfs(i, j);
				}
			}
			
			
			// 메소드를 활용해 만들어준 외부 공간과 없어져야하는 치즈를 모두 0으로 바꾼다. 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 1) map[i][j] = 0;
				}
			}
			count ++;			
		}
		
		System.out.println(count);
		
	}
	
	// 외부 공간과 두개이상 닿는 치즈를 2로 만드는 메소드
	// 이후에 모두 0으로 만들어 준다.
	static void bfs(int r, int c) {
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r, c});
		visited[r][c] = true;
		
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int zcount = 0;
			
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if (!check(nr, nc)) continue;
				if (map[nr][nc] == 5) zcount++;	
				if (map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					que.add(new int[] {nr, nc});
				}
			}
						
			if(zcount >= 2) {
				map[temp[0]][temp[1]] = 2;
			}
		}
		
	}
	
	// 외부 공간을 5로 바꾸는 메소드
	// 이후에 모두 0으로 만들어 준다.
	static void changeCheese(int r, int c) {
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r, c});
		map[r][c] = 5;
		
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if (!check(nr, nc)) continue;
				if (map[nr][nc] == 0) {
					map[nr][nc] = 5;
					que.add(new int[] {nr, nc});
				}
			}
		}
		
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
