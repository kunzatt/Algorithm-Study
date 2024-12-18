import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ㅏ ㅗ ㅜ ㅓ 모양 처리하는데 시간이 오래 걸렸다..!

public class Main_14500 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int maxsum = 0;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c =0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}	// 입력 끝
		
		for(int r=0; r<N; r++) {	// map을 돌면서 시작점을 기준으로 가능한 테트로미노를 모두 검사해본다.
			for(int c=0; c<M; c++) {
				visited[r][c] = true;	// 시작점 방문 표시
				dfs(1, r, c, map[r][c]);
				visited[r][c] = false;	// 방문 풀어주기 (ㄱ 자 모양 고려...)
				T(r, c);	// ㅏ ㅗ ㅜ ㅓ 모양 처리

			}
		}
		
		System.out.println(maxsum);
	}

	private static void T(int r, int c) {	// ㅏ ㅗ ㅜ ㅓ 모양 처리
		
		for(int i=0; i<4; i++) {
			int sum = map[r][c];
			for(int d=0; d<3; d++) {
				int nr = r + dr[(d+i)%4];
				int nc = c+dc[(d+i)%4];
				
				if(check(nr, nc)) {
					sum+= map[nr][nc];
				}
			}
			maxsum = Math.max(maxsum, sum);
		}
		
	}

	private static void dfs(int depth, int r, int c,int sum) {

		if(depth == 4) {
			maxsum = Math.max(maxsum, sum);
			return;
		}
		
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c+dc[d];
			
			if(check(nr, nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;		// 방문체크
				dfs(depth+1, nr, nc, sum+map[nr][nc]);	//dfs로 다음 블럭을 이어붙여본다. 
				visited[nr][nc] = false;	// 방문표시 원상복구
			}
		}
	}

	private static boolean check(int r, int c) {
		// TODO Auto-generated method stub
		return r>=0 && r<N && c>=0 && c<M;
	}
	
}
