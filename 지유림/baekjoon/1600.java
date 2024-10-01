import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 입력값 0: 평지 / 1: 장애물
	static int K, W, H;	// W : 가로길이 / H : 세로길이
	static int[][] map;
	static int[][] dd4 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] dd8 = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
	static boolean[][][] visited;
	static class Point {
		int r, c, t, k;

		public Point(int r, int c, int t, int k) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
			this.k = k;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int result = bfs(H-1, W-1);
		
		System.out.println(result);
	}
	
	// 도착점을 파라미터로 주기
	static int bfs(int er, int ec) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0, 0, 0, K));
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			if(p.r == er && p.c == ec) {
				return p.t;
			}
			
			int nr, nc, nt;
			int nk = p.k;
			
			for(int i = 0; i < 4; i++) {
				nr = p.r+dd4[i][0];
				nc = p.c+dd4[i][1];
				nt = p.t;
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc][nk]) continue;
				if(map[nr][nc] == 1) continue;
				
				// 4방에서 통과하기
				visited[nr][nc][nk] = true;
				que.offer(new Point(nr, nc, nt+1, nk));
			}
			
			
			if(nk > 0) {
				for(int i = 0; i < 8; i++) {
					nr = p.r+dd8[i][0];
					nc = p.c+dd8[i][1];
					nt = p.t;
					
					if(!check(nr, nc)) continue;
					if(visited[nr][nc][nk-1]) continue;
					if(map[nr][nc] == 1) continue;
					
					
					// 8방에서 통과된거면 K를 한번 쓴거니까 -1
					visited[nr][nc][nk-1] = true;
					que.offer(new Point(nr, nc, nt+1, nk-1));
				}
			}
		}
		
		return -1;
		
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
}
