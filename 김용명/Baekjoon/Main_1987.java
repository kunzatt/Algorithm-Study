import java.io.*;
import java.util.*;

public class Main_1987 {
	
	static int R, C, max;
	static int[][] map;
	static boolean[] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		
		max = Integer.MIN_VALUE;
		dfs(0, 0, 0);
		
		if (R == 1 && C == 1) System.out.println(1);
		else System.out.println(max);

	}

	static void dfs(int r, int c, int count) {
		
		if (visited[map[r][c]]) {
			max = Math.max(max, count);
			return;
		}
		else {			
			visited[map[r][c]] = true;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (!check(nr, nc)) continue; 
				dfs(nr, nc, count+1);
			}
			
			visited[map[r][c]] = false;			
		}		
				
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

}
