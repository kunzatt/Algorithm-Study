import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2638_치즈 {
	static int N, M;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static List<Point> cheeze;	// 치즈 담아둘 리스트
	static int chCnt;	// 치즈 개수
	static boolean[][] visited;
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		
		cheeze = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 치즈인것만 모아두기
				if(map[i][j] == 1) {
					cheeze.add(new Point(i, j));
					chCnt++;
				}
			}
		}
		
		int time = 0;
		
		// 남아있는 치즈 없을때까지
		while(chCnt != 0) {
			// 시간세기
			time++;
			
			// 방문여부는 계속 초기화 시켜주기
			visited = new boolean[N][M];
			// 외부공기인것만 판별해야 하니까 bfs 돌려서 외부공기만 2로 바꾸기
			bfs(0, 0);
			
			// 치즈 녹이자요
			melting();
		}
		
		System.out.println(time);
		
		
		
		
		
		
	}
	
	// 외부공기인지 판별하기
	static void bfs(int r, int c) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(r, c));
		visited[r][c] = true;
		map[r][c] = 2;
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc] || map[nr][nc] == 1) continue;
				
				map[nr][nc] = 2;	// 외부공기는 2로 바꿔주자
				que.add(new Point(nr, nc));	// 공기만 queue에 담기
				visited[nr][nc] = true;
			}
		}
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	static void melting() {
		
		// size를 지정해두면 밑에서 삭제하면서 index에러남
		for(int i = 0; i < cheeze.size(); i++) {
			int r = cheeze.get(i).r;
			int c = cheeze.get(i).c;
			
			// 외부공기와 맞닿는게 몇개인지 셀 변수
			int count = 0;
			
			for(int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(!check(nr, nc)) continue;
				
				if(map[nr][nc] == 2) count++;
			}
			
			// 외부공기와 맞닿은게 2 이상이면 맵에서 삭제
			if(count >= 2) {
				map[r][c] = 0;
				chCnt--;	// 치즈 개수 삭제
				cheeze.remove(i);	// 리스트에서도 삭제
				i--;	// 삭제했으니까 i도 -1 해주면서 ㄱ ㅡ다음거 볼 수있게
			}
			
			
		}
		
	}
}
