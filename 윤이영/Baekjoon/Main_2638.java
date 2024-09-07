import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638 {
	static int h, w;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		int count=0;                      
		map = new int[h][w];

		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) count++;	// 치즈 세기
			}
		}
		int ff = 2;
		
		// 치즈가 남아있을 동안 반복
		while(count > 0) {
			visited = new boolean[h][w];	// 방문 체크 배열 초기화
			bfs(0,0,ff);
			count = chz(ff++);
			//print();
		}
		System.out.println(ff-2);
		
	}
	
	// 치즈를 센다
	static int chz(int ff) {
		int check;
		boolean flag;
		int cnt = 0;	// 치즈의 개수
		for(int r=0; r<h; r++) {
			for(int c=0; c<w; c++) {
				check = 0;
				flag = false;
				if(map[r][c] == 1) {	// 치즈라면
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];	// 4방을 탐색해본다
						if(check(nr, nc) && map[nr][nc] == ff) {	
							check++; // 공기와 닿아있는 치즈라면
						}
					}
				}
				if(map[r][c] == 1 && check < 2) cnt++;	// 녹지못하는 치즈 카운트
				if(check >=2) map[r][c] = ff+1;	// 공기와 닿아있는 치즈는 녹인다.
				
			}
		}

		return cnt;
	}

	private static void bfs(int sr, int sc, int f) {
		Queue<int[]> que = new LinkedList<>();
		
		que.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] != 1) {
					map[nr][nc] = f;
					que.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
				
			}
		}
		
	}

	// 2차원 배열의 범위 내에 있는지 체크하는 메서드
	private static boolean check(int nr, int nc) {

		return nr >= 0 && nr < h && nc >= 0 && nc < w;
	}
	
	// 2차원 배열 프린트 해보는 메서드
	public static void print() {
		for(int i=0; i<h; i++) {
			for(int j=0;j<w; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
}