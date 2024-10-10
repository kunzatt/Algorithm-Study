import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8382 {
	static int r, c;
	static int T;
	static int N = 201;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0,1,0,-1}; 	// 위부터 시계방향
	static boolean[][][] visited;
	static int mindist;
	
	static class Point {
		int r, c, dir, dist;

		public Point(int r, int c, int dir, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.dist = dist;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			r = Math.abs(x1-x2);
			c = Math.abs(y1-y2);
			sb.append("#"+t+" ");
			visited = new boolean[N][N][2];
			bfs();
			sb.append(mindist);
			System.out.println(sb);
		}
	}

	private static void bfs() {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0,0,0,0));
		que.offer(new Point(0,0,1,0));	// r, c, dir, dist
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			if(cur.r == r && cur.c == c) {
				mindist = cur.dist;
				return;
			}
			
			for(int d=cur.dir; d<4; d+=2) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(!check(nr, nc)) continue;
				if (visited[nr][nc][cur.dir]) continue;
				
				visited[nr][nc][cur.dir]= true; 
				que.offer(new Point(nr, nc, 1-cur.dir, cur.dist+1));
				
			}
			
		}

	}

	private static boolean check(int r, int c) {
		// TODO Auto-generated method stub
		return r >= 0 && r < N && c >= 0 && c <N;
	}
}
