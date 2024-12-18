import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int mindist;
	
	static class pos implements Comparable<pos>{
		int r, c, w, total;

		public pos(int r, int c, int w, int total) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
			this.total = total;
		}

		@Override
		public int compareTo(pos o) {
			return Integer.compare(this.total, o.total);
		}

		@Override
		public String toString() {
			return "pos [r=" + r + ", c=" + c + ", w=" + w + ", total=" + total + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}
			map = new int[N][N];
			visited = new boolean[N][N];
			mindist = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			System.out.printf("Problem %d: %d\n", T++, mindist);
		}
		
	}


	private static void bfs() {
		PriorityQueue<pos> pq = new PriorityQueue<>();
		pq.add(new pos(0,0, map[0][0],map[0][0]));	
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			pos cur = pq.poll();
			int r = cur.r;
			int c = cur.c;
			//System.out.println(cur.toString());
			
			if(cur.r == N-1 && cur.c == N-1) {
				mindist = Math.min(mindist, cur.total);
			}
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				
				pq.add(new pos(nr, nc, map[nr][nc], cur.total + map[nr][nc]));
				visited[nr][nc] = true;
			}
		}
		

	}


	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
