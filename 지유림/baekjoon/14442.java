import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14442_벽부수고이동하기2 {
	static int N, M, K;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] drc = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	static class Point {
		int r, c, k, t;

		public Point(int r, int c, int k, int t) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.t = t;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][K+1];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(N-1, M-1));
	}
	
	static int bfs(int er, int ec) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0, 0, K, 1));
		visited[0][0][K] = true;
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			if(p.r == er && p.c == ec) {
				return p.t;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r+drc[d][0];
				int nc = p.c+drc[d][1];
				int nk = p.k;
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc][nk]) continue;
				
				if(map[nr][nc] == 1 && nk > 0) {
					que.offer(new Point(nr, nc, nk-1, p.t+1));
					visited[nr][nc][nk] = true;
					
				} else if(map[nr][nc] == 0) {
					que.offer(new Point(nr, nc, nk, p.t+1));
					visited[nr][nc][nk] = true;
				}
			}
			
		}
		
		return -1;
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
