import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194 { 

    static int N, M, sr, sc;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static class Node {
    	int r;
    	int c;
    	int cnt;
    	int key;
		public Node(int r, int c, int cnt, int key) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        
        for (int r = 0; r < N; r++) {
        	map[r] = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				if (map[r][c]=='0') {
					sr = r;
					sc = c;
				}
			}
		}
        
        bfs();
        
    }
    
    public static void bfs() {
    	Queue<Node> pq = new LinkedList<>();
    	pq.add(new Node(sr,sc,0,0));
    	
    	boolean[][][] visit = new boolean[N][M][64];
    	visit[sr][sc][0] = true;
    	
    	while (!pq.isEmpty()) {
    		Node cur = pq.poll();
    		
    		if (map[cur.r][cur.c]=='1') {
    			System.out.println(cur.cnt);
    			return;
    		}
    		
    		for (int d = 0; d < 4; d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
								
				if (!check(nr,nc)) continue;
				if (map[nr][nc]=='#' || visit[nr][nc][cur.key]) continue;
				
				if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					int key = cur.key | (1 << (map[nr][nc]-'a'));
					pq.add(new Node(nr,nc,cur.cnt+1,key));
					visit[nr][nc][key] = true;
				}else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					boolean flag = (cur.key & (1 << (map[nr][nc]-'A'))) != 0;
					if (flag) {
						pq.add(new Node(nr, nc, cur.cnt+1, cur.key));
						visit[nr][nc][cur.key] = true;
					}
				} else {
					pq.add(new Node(nr, nc, cur.cnt+1, cur.key));
					visit[nr][nc][cur.key] = true;
				}
			}
    		
    	}
    	
    	System.out.println(-1);
    }

	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}
	
}
