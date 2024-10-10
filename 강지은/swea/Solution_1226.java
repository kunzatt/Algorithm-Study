import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1226 {
	
	static int T = 10;
	static int[][] map;
	static boolean[][] visit;
	static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean isSuccess;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= T; t++) {
			int tcase = Integer.parseInt(br.readLine());
			int sr = 0;
			int sc = 0;
			
			isSuccess = false;
			
			visit = new boolean[16][16];
			map = new int[16][16];
			for (int r = 0; r < 16; r++) {
				char[] tmp = br.readLine().toCharArray();
				for (int c = 0; c < 16; c++) {
					map[r][c] = tmp[c]-'0';
					if (map[r][c] == 2) {
						sr = r;
						sc = c;
					}
				}
			}
			
			visit[sr][sc] = true;
			miro(sr, sc);
			
			if (isSuccess) {
				System.out.printf("#%d %d\n", tcase, 1);
			} else {
				System.out.printf("#%d %d\n", tcase, 0);
			}
			
		}

	}

	private static void miro(int r, int c) {
		if (map[r][c] == 3) {
			isSuccess = true;
			return;
		}
		
		for (int[] d : directions) {
			int nr = r+d[0];
			int nc = c+d[1];
			
			if (!check(nr, nc)) continue;
			if (visit[nr][nc] || map[nr][nc] == 1) continue;
			visit[nr][nc] = true;
			miro(nr,nc);
			visit[nr][nc] = false;
		}
		
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<16 && 0<=c && c<16;
	}

}
