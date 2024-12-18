import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs를 활용한 풀이!

public class Main_4963 {
	static int w,h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, -1, 0, 1, -1, 1};
	static int[] dc = {-1, -1, -1, 1, 1, 1, 0, 0};
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w== 0 && h == 0) break;
			map = new int[h][w];
			visited = new boolean[h][w];
			
			// 섬 입력 받기
			for(int r=0; r<h; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c<w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken().trim());
				}
			}
			
			count = 0;	// 섬의 개수 초기화
			// 탐색 시작
			for(int r = 0; r<h; r++) {
				for(int c = 0; c<w; c++) {
					if(!visited[r][c] && map[r][c] == 1) {
						dfs(r, c);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
		
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;	// 방문 표시
		
		for(int d=0; d<8; d++) {	// 8방 탐색
			int nr = r+ dr[d];
			int nc = c + dc[d];
			if(check(nr, nc)) {	// 범위 내에 있다면
				if(!visited[nr][nc] && map[nr][nc]== 1) {	// 방문하지 않은 섬이라면
					dfs(nr, nc);	// 탐색(재귀)
				}
			}
			
		}
	}

	static boolean check(int nr, int nc) {
		return nr >= 0 && nr < h && nc >= 0 && nc < w;
	}
}
