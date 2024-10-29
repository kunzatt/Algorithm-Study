import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 1. dfs를 이용하여 알파벳을 선택함
 * 2. 알파벳을 1차원 배열의 숫자로 바꿔서 방문한 알파벳인지 체크
 * 3. 백트래킹 유의하기
 */
public class Main_1987 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[] alpha = new boolean[26];
	static int maxcount = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		dfs(0,0, 1);
		
		System.out.println(maxcount);
		
	}

	private static void dfs(int r, int c, int count) {
		if(count >= maxcount) {
			maxcount = count;
		}
		alpha[map[r][c]-65] = true;
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!check(nr, nc)) continue;
			if(visited[nr][nc] || alpha[map[nr][nc] - 65]) continue;
			visited[nr][nc] = true;
			dfs(nr, nc, count+1);
			visited[nr][nc] = false;
		}
		alpha[map[r][c]-65] = false;
		return;
	}

	private static boolean check(int r, int c) {
		// TODO Auto-generated method stub
		return r>= 0 && r<R && c>=0 && c<C;
	}
}