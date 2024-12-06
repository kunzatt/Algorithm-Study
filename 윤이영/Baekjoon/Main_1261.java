import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int b;
		public Node(int r, int c, int b) {
			this.r = r;
			this.c = c;
			this.b = b;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(b, o.b);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}	// 입력 완료
		
		int ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, 0));
		visited[0][0] = true;
		int wall = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int r = cur.r;
			int c = cur.c;
			if(r == (N-1) && c == (M-1)) {
				wall = cur.b;
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!check(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				if(map[nr][nc] == 1) {
					pq.add(new Node(nr, nc, cur.b+1));
				}
				else {
					pq.add(new Node(nr, nc, cur.b));
				}
				
			}
		}
		
		return wall;
		
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
