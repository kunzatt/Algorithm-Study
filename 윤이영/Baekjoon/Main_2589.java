import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589 {
	static char[][] map;
	static int[][] check;
	static int[][] time;
	static int N, M;
	static int ans = 0;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		check = new int[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 각 보물마다 최장거리의 보물을 BFS로 구한다.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'L') {
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
		
		System.out.println(ans);
	}
	
	private static int bfs(int sr, int sc) {
		Queue<int[]> que = new LinkedList<>();
		time = new int[N][M];
		que.add(new int[] {sr, sc});
		time[sr][sc] = 1;
		int t = 1;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r= cur[0];
			int c= cur[1];
			t = Math.max(t, time[r][c]);
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!check(nr, nc)) continue;
				if(time[nr][nc] != 0 ) continue;
				if(map[nr][nc] == 'L') {
					time[nr][nc] = time[r][c] + 1;
					que.add(new int[] {nr, nc});
				}
			}
		}
		
		return t-1;
		
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}



