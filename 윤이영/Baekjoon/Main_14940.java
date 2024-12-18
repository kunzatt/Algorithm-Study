import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940 {
	static int n, m;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];
		visited = new boolean[n][m];
		
		int sr=0;
		int sc = 0;
		for(int r=0; r<n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				dist[r][c] = -1;
				if(map[r][c] == 2) {
					sr = r;
					sc = c;
					dist[r][c] = 0;
				}
				if(map[r][c] == 0) {
					dist[r][c] = 0;
				}
			}
		}
		
		bfs(sr, sc);
		for(int r=0; r<n; r++) {
			for(int c = 0; c<m; c++) {
				System.out.print(dist[r][c]+" ");
			}
			System.out.println();
		}
	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {sr, sc});
		visited[sr][sc] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] != 0) {
					dist[nr][nc] = dist[r][c] + 1;
					que.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
				
			}
			
		}
	}

	private static boolean check(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr >= 0 && nr < n && nc >= 0 && nc <m;
	}
}
