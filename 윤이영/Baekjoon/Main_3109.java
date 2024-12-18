import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	static int ans;
	// 오른쪽, 오른쪽 아래 대각선, 오른쪽 위 대각선으로 연결할 수 있다.
	// 최대한 여러개의 파이프라인을 설치하려고 한다.
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		ans = 0;
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<R; i++) {
			if(map[i][0] == '.') {
				flag = false;
				dfs(i, 0);
				//print();
			}
		}
		
		System.out.println(ans);
		
	}

	private static void dfs(int sr, int sc) {
		
		if(sc == C-1) {
			ans++;
			flag = true;
			return;
		}
		
		for(int d=0; d<3; d++) {
			int nr = sr+dr[d];
			int nc = sc+dc[d];
			
			if(!check(nr, nc)) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc] != '.') continue;
			visited[nr][nc] = true;
			dfs(nr, nc);
			if(flag) {
				map[nr][nc] = (char) ('0'+ans);
				return;
			}
		}

	}

	private static boolean check(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr >= 0 && nr <R && nc >= 0 && nc < C;
	}
}
