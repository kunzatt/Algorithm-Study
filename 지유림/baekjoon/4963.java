import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H, W, nr, nc; // 범위, 현재 위치한 r, c
	static int[][] map; // 지도
	static boolean[][] visited; // 방문횟수
	static int count; // 섬 개수
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception {
		// 입력이 몇개 들어오는지 모르니까 bufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		while((str = br.readLine()) != null && !str.isEmpty()) {
			StringTokenizer st = new StringTokenizer(str);

			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W == 0 && H == 0) return;
			
			map = new int[H][W];
			visited = new boolean[H][W];
			count = 0;
			
			
			// 입력받기
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			// 맵을 돌면서 방문하지 않았고, 섬인 곳에서 출발
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					
					if(!visited[i][j] && map[i][j] == 1) {
						count++;
						dfs(i, j);
					}
				}
			}
			
			System.out.println(count);
			
		}
	}
	
	
	// 기존에 받았던 r, c로 하게 되면 8방 돌릴때 변화함
	// -> 새로운 위치 선정해줄 변수 넣기!
	static void dfs(int r, int c) {
		// 찾으면 방문한거니까 true
		visited[r][c] = true;
		
		// 8방 돌기
		for(int i = 0; i < 8; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			
			// 범위 안이고, 방문 안했고 섬인 곳
			if(check(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}
	
	static boolean check(int r, int c) {
		return 0 <= r && r < H && 0 <= c && c < W;
	}
}
