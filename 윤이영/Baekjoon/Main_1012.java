import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs와 floodfill을 사용하여 풀이

public class Main_1012 {
	static int T;
	static int M, N, K;
	static int f;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			
			f = 2;	
			//print();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(!visited[i][j] && map[i][j] != 0) {
						bfs(i, j, f);
						f++;	
						//print();
					}
						
				}
			}
			
			System.out.println(f-2);
		}
		
	}


	private static void bfs(int sr, int sc, int f) {
		Queue<int[]> que = new LinkedList<>();
		
		que.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		map[sr][sc] = f;
		
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
					map[nr][nc] = f;
					visited[nr][nc] = true;
					que.offer(new int[] {nr, nc});
				}
			}
		}
	}

	 static boolean check(int r, int c) {
		// TODO Auto-generated method stub
		return r >= 0 && r<N && c >= 0 && c <M;
	}
	 
	 
	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
	}

}
