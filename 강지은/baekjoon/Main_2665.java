import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_2665 {
	
	static int N;
	static char[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int cnt;
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node o) {
			return this.cnt-o.cnt;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        
        for (int r = 0; r < N; r++) {
        	map[r] = br.readLine().toCharArray();
		}
        
        bfs(0, 0, 0);
    }

	private static void bfs(int r, int c, int cnt) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(r, c, cnt));
		
		boolean[][] visit = new boolean[N][N];
		visit[r][c] = true;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.r==N-1 && cur.c==N-1) {
				System.out.println(cur.cnt);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				
				if (!check(nr,nc)) continue;
				if (visit[nr][nc]) continue;
				if (map[nr][nc] == '0') {
					visit[nr][nc] = true;
					pq.add(new Node(nr, nc, cur.cnt+1));
				} else {
					visit[nr][nc] = true;
					pq.add(new Node(nr, nc, cur.cnt));
				}
				
			}
		}
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}

}
