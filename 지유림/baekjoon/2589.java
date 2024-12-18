import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589_보물섬 {
	static int N, M;
	static char[][] map;
	static class Point {
		int r, c, time;

		public Point(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	static int[][] drc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'L') {
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		
		System.out.println(max);
	
	}
	
	
	static int bfs(int r, int c) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(r, c, 0));
		boolean[][] visited = new boolean[N][M];
		visited[r][c] = true;
		
		int time = 0;
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			if(time < p.time) {
				time = p.time;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r+drc[d][0];
				int nc = p.c+drc[d][1];
				
				if(!check(nr, nc) || visited[nr][nc] || map[nr][nc] == 'W') continue;
				
				que.offer(new Point(nr, nc, p.time+1));
				visited[nr][nc] = true;
			}
		}
		
		return time;
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
