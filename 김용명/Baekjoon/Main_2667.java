import java.io.*;
import java.util.*;

public class Main_2667 {
	
	static int N, count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		count = 0;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					count++;
					bfs(i, j);					
				}
			}
		}
				
		sb.append(count).append("\n");
		List<Integer> list = new ArrayList<>();
		
		for (int k = 1; k <= count; k++) {
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == k) {
						ans++;
					}
				}
			}
			list.add(ans);
		}
		
		Collections.sort(list);
		
		for (int i : list) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);

	}

	static void bfs(int r, int c) {
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r, c});
		visited[r][c] = true;
		map[r][c] = count;
		
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if (!check(nr, nc) || visited[nr][nc] || map[nr][nc] == 0) continue;
				visited[nr][nc] = true;
				que.add(new int[] {nr, nc});
				map[nr][nc] = count;
			}
		}
		
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
