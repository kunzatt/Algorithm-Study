import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {
	static int N, M, r, c, d;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int cnt=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	// 입력 끝
		
		clean(r, c, d);
		System.out.println(cnt);
	}

	private static void clean(int sr, int sc, int dir) {
		if(map[sr][sc] == 0) {
			map[sr][sc] = 2;
			cnt++;
		}
		
		// 현재 주변 4칸 중 청소되지 않은 빈칸이 있는지 확인
		for(int d=0; d<4; d++) {
			dir = (dir+3)%4;	// 반시계방향으로 회전
			int nr = sr+dr[dir];
			int nc = sc+dc[dir];
			
			if(!check(nr, nc)) continue;
			if(map[nr][nc] == 0) {
				clean(nr, nc, dir);
				return;
			}
		}
		
		// 후진 시도 (바라보는 방향을 유지한채)
	    int backDir = (dir + 2) % 4;
	    int nr = sr + dr[backDir];
	    int nc = sc + dc[backDir];
	    if (check(nr, nc)) {
	    	if (map[nr][nc] == 1) return; // 벽이면 멈춤
	    	clean(nr, nc, dir);           // 후진

	    }
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
