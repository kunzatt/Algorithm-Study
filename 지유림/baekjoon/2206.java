import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206_벽부수고이동하기 {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Point {
		int r, c, w, t;
		// r, c => x, y 
		// w => 벽 부술 수 있는 개수 
		// t => 최단거리 체크

		public Point(int r, int c, int w, int t) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
			this.t = t;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		// 벽부수는거 확인여부
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int count = bfs(N-1, M-1);
		
		System.out.println(count);
	}
	
	static int bfs(int er, int ec) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0, 0, 1, 1));
		visited[0][0][1] = true;
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			if(p.r == er && p.c == ec) {
				return p.t;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				int nw = p.w;
				
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc][nw]) continue;
				if(nw == 0 && map[nr][nc] == 1) continue;
				
				if(map[nr][nc] == 1 && nw == 1) {
					que.offer(new Point(nr, nc, nw-1, p.t+1));
					visited[nr][nc][nw] = true;
				} else if(map[nr][nc] == 0) {
					que.offer(new Point(nr, nc, nw, p.t+1));
					visited[nr][nc][nw] = true;
				} 
			}
		}
		
		return -1;
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
