import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 써보기~
public class Main4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] map;
	static int[][] drc = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	static class Point implements Comparable<Point> {
		int r, c, k;

		public Point(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
		@Override 
		public int compareTo(Point p) {
			// k가 작은게 우선 순위
			if(p.k > this.k) return -1;
			else return 1;
		}
	}
	static int[][] rupee;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		
		// 입력 몇개 들어오는 지 모름
		int count = 0;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;	// 0 들어오면 종료
			
			count++;
			map = new int[N][N];
			rupee = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					rupee[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			
			
			// 끝나는 위치는 N-1 고정이다
			sb.append("Problem ").append(count).append(": ").append(rupee[N-1][N-1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	
	
	static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, map[0][0]));	// 시작 위치는 0, 0 고정!
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r+drc[d][0];
				int nc = p.c+drc[d][1];
				
				if(!check(nr, nc)) continue;
				
				int nowRupee = p.k+map[nr][nc];
				
				// 현재 루피가 더 작은경우에 갱신
				if(nowRupee < rupee[nr][nc]) {
					rupee[nr][nc] = nowRupee;
					pq.offer(new Point(nr, nc, nowRupee));
				}
			}
		}
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
