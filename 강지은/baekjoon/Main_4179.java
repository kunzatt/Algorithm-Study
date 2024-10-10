
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {
    
	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Queue<int[]> jihoon, fire;
	static int fireSize, jihoonSize;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		
		jihoon = new LinkedList<>();
		fire = new LinkedList<>();
		int time = 0;
		
		for (int r = 0; r < R; r++) {
			char[] tmp = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = tmp[c];
				if (map[r][c]=='J') {
					jihoon.add(new int[] {r,c, time});
					visit[r][c] = true;
				}
				if (map[r][c]=='F') fire.add(new int[] {r,c});
			}
		}
		
		while (!jihoon.isEmpty()) {
			fireSize = fire.size();
			moveFire();
			
			jihoonSize = jihoon.size();
			move();
			
			if (flag) return;
		}
		
		System.out.println("IMPOSSIBLE");
		
	}

	private static void move() {
		for (int i = 0; i < jihoonSize; i++) {
			int[] cur=jihoon.poll();
			int time = cur[2]+1;
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (!check(nr,nc)) {
					System.out.println(time);
					flag = true;
					return;
				}
				if (visit[nr][nc] || map[nr][nc]=='#' || map[nr][nc]=='F') continue;
				
				jihoon.add(new int[] {nr, nc, time});
				visit[nr][nc] = true;
			}
		}
		
	}

	private static void moveFire() {
		for (int i = 0; i < fireSize; i++) {
			int[] cur = fire.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (!check(nr, nc)) continue;
				if (map[nr][nc]=='#' || map[nr][nc]=='F') continue;
				
				fire.add(new int[] {nr,nc});
				map[nr][nc] = 'F';
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<R && 0<=c && c<C;
	}

}
