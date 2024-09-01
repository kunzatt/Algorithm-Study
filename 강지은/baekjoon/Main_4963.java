import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963 {
	
	static int w, h;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			if (w == 0 & h == 0) {
				break;
			}
			
			visit = new boolean[w][h];
			map = new int[w][h];
			for (int r = 0; r < w; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < h; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for (int r = 0; r < w; r++) {
				for (int c = 0; c < h; c++) {
					if (!visit[r][c] && map[r][c] == 1) {
						dfs(r, c);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}

	}

	private static void dfs(int r, int c) {
		visit[r][c] = true;
		
		for (int i = 0; i < 8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if (!(0 <= nr && nr < w && 0 <= nc && nc < h))
				continue;
			
			if (!visit[nr][nc] && map[nr][nc] == 1)
				dfs(nr, nc);
			
		}
		
	}

}
