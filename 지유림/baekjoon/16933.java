import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16933_벽부수고이동하기3 {
	static int N, M, K;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] drc = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	static class Point {
		int r, c, k, t, d;

		// r, c : 좌표
		// k : 이동횟수
		// t : 시간
		// d : 낮 or 밤 => 낮: 1 / 밤: 0
		public Point(int r, int c, int k, int t, int d) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.t = t;
			this.d = d;
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
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(N-1, M-1));
		
	}
	
	static int bfs(int er, int ec) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0, 0, K, 1, 1));
		// 1, 1 에서 시작인데 그냥 0, 0 에서 시작
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
				int nd = p.d;
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc][nk]) continue;
				
				
				if(map[nr][nc] == 1 && nk > 0 && nd == 1) {// 부실 수 있고, 낮 일때
					que.offer(new Point(nr, nc, nk-1, p.t+1, 0));
					visited[nr][nc][nk] = true;
					// 부수고, 밤으로 바꾼다.
				} else if(map[nr][nc] == 1 && nk > 0 && nd == 0) { // 부실 수는 있는데, 밤 일때
					que.offer(new Point(p.r, p.c, nk, p.t+1, 1));
					// 하룻밤 기다려서 부수자
				} else if(map[nr][nc] == 0 && nd == 1) {	// 0이고 낮일 때
					que.offer(new Point(nr, nc, nk, p.t+1, 0)); // 이동하고 밤으로 변경
					visited[nr][nc][nk] = true;
				} else if(map[nr][nc] == 0 && nd == 0) {	// 0이고 밤일 때
					que.offer(new Point(nr, nc, nk, p.t+1, 1)); // 낮으로 변경
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
