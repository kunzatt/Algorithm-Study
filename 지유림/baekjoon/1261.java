import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1261_알고스팟 {
	static int N, M;
	static int[][] map;
	static class Point {
		int r, c, t;

		public Point(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	static boolean[][] visited;
	static int[][] drc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(dijkstra());
	}

  // 오름차순으로 정렬!
	static int dijkstra() {
		PriorityQueue<Point> que = new PriorityQueue<>((o1, o2) -> o1.t - o2.t);
		que.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			if(p.r == N-1 && p.c == M-1) {
				return p.t;
			}
			
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r+drc[d][0];
				int nc = p.c+drc[d][1];
				
				if(!check(nr, nc) || visited[nr][nc]) continue;
				
				if(map[nr][nc] == 0) {
					que.offer(new Point(nr, nc, p.t));
					visited[nr][nc] = true;
				} else if(map[nr][nc] == 1) {
					que.offer(new Point(nr, nc, p.t+1));
					visited[nr][nc] = true;
				}
			}
		}
		
		return 0;
		
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
