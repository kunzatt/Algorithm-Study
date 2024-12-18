import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 뭔가 게리맨더링+치즈..? 같은 느낌이라 생각외로 금방 풀었다;;
public class Main14502_연구소 {
	static int N, M;
	static int[][] map;
	static class Point {
		int r, c, w;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		result = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		createWall(0);	// 벽 세우기
		System.out.println(result);
	}
	
	// 벽 세개 세우기..
	static void createWall(int cnt) {
		if(cnt == 3) {	// 벽 3개 다 세운것
			ff();	// 3개 다 세웠으면 바이러스 퍼트리자~
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					createWall(cnt+1);
					map[i][j] = 0; // 다시 원래대로 돌려놔야함
				}
			}
		}
	}
	
	// 바이러스 퍼트리기
	static void ff() {
		Queue<Point> que = new LinkedList<>();
		
		int[][] copyMap = new int[N][M];	// 벽세운애가 다시 돌리니까 복사해놓기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					que.offer(new Point(i, j));
				}
			}
		}
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r+drc[d][0];
				int nc = p.c+drc[d][1];
				
				if(!check(nr, nc)) continue;
				if(copyMap[nr][nc] == 0) {
					copyMap[nr][nc] = 2;
					que.offer(new Point(nr, nc));
				}
			}
		}
		
		safeCount(copyMap);
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	static void safeCount(int[][] map) {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) count++;
			}
		}
		
		result = Math.max(result, count);
	}
}
