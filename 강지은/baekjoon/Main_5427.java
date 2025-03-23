import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427 {
	
	static int T, W, H;
	static char[][] map;
	static boolean[][] visit;
	
	static Queue<int[]> sang, fire;
	static int sangSize, fireSize;
	static boolean flag;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			visit = new boolean[H][W];
			
			sang = new LinkedList<>();
			fire = new LinkedList<>();
			
			sangSize = 0;
			fireSize = 0;
			
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (map[i][j]=='@') {
						sang.add(new int[] {i, j});
						visit[i][j] = true;
					} else if (map[i][j]=='*') {
						fire.add(new int[] {i, j});
						visit[i][j] = true;
					}
				}
			}
			
			int time = 1;
			flag = false;
			
			while (!sang.isEmpty()) {
				// 불 이동
				fireSize = fire.size();
				moveFire();
				
				// 상근 이동
				sangSize = sang.size();
				move();
				
				if (flag) {
					System.out.println(time);
					break;
				}
				
				time++;
			}
			
			if (!flag) System.out.println("IMPOSSIBLE");
		}
        
    }

	private static void move() {
		for (int i = 0; i < sangSize; i++) {
			int[] cur = sang.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (!check(nr, nc)) {
					flag = true;
					return;
				}
				
				if (visit[nr][nc]) continue;
				if (map[nr][nc]=='#' || map[nr][nc]=='*') continue;
				
				visit[nr][nc] = true;
				sang.add(new int[] {nr, nc});
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
				if (visit[nr][nc]) continue;
				if (map[nr][nc]=='#' || map[nr][nc]=='*') continue;
				
				visit[nr][nc] = true;
				map[nr][nc] = '*';
				fire.add(new int[] {nr, nc});
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<H && 0<=c && c<W;
	}
}
