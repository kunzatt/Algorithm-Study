import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667 {
	
	static int N;
	static int[][] map;
	static int group;
	static int[] gnums;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			char[] tmp = br.readLine().toCharArray();
			for (int c = 0; c < N; c++) {
				map[r][c] = tmp[c]-'0';
			}
		}
		
		group = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					bfs(r, c, ++group);
				}
			}
		}
		
		
		gnums = new int[group-1];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int k = 2; k < group+1; k++) {
					if (map[r][c] == k)
						gnums[k-2]++;
				}
			}
		}
		
		Arrays.sort(gnums);
		System.out.println(gnums.length);
		for (int i = 0; i < gnums.length; i++) {
			System.out.println(gnums[i]);
		}
		
	}

	private static void bfs(int sr, int sc, int group) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {sr, sc});
		
		map[sr][sc] = group;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if (!check(nr, nc)) continue;
				if (map[nr][nc] == 1) {
					queue.offer(new int[] {nr, nc});
					map[nr][nc] = group;
				}
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

}
