import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// bfs인줄 알았는데.. dfs였음 ㅠㅠ
public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int count = 0;
		
		for(int i = 0; i < R; i++) {
			if(dfs(i, 0)) count++;
		}
		
		System.out.println(count);
	}
	
	static boolean dfs(int r, int c) {
		
		if(c == C-1) {	// 마지막 열에 도달하면 return
			return true;
		}
		
		//System.out.println("DFS 호출 시작: (" + r + ", " + c + ")");
		
		for(int d = 0; d < 3; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!check(nr, nc)) continue;		// 범위체크
			if(visited[nr][nc]) continue;		// 방문체크
			if(map[nr][nc] == 'x') continue;	// 건물있으면 파이프 못놓음
			
			//System.out.println("방문 중: (" + nr + ", "  + nc + ")");
			visited[nr][nc] = true;
			
			if(dfs(nr, nc)) {
				return true;
			}
		}
		return false;
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
