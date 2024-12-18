import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 1. 7공주를 뽑는다.(DFS 사용 / 2차원 -> 1차원 배열로 만들어서 뽑는다.)
// 2. 7공주 중에서 다솜파가 4명 이상인지 확인한다.
// 3. 4명 이상인 경우, 7공주가 서로 이어져 있는지 확인한다.

public class Main_1941 {
	static char[][] map = new char[5][5];
	static boolean[][] visited = new boolean[5][5];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<5; i++) {
			map[i] = br.readLine().toCharArray();
		}// 입력 끝
		
		dfs(0, 0, 0);
		
		System.out.println(count);
	}

	private static void dfs(int start, int depth, int som) {
		if(depth == 7) {
			if(som >= 4  && isConnected())
				count++;
			return;
		}
		for(int i=start; i<25; i++) {
			int r = i/5;
			int c = i%5;
			if(visited[r][c]) continue;
			visited[r][c] = true;
			if(map[r][c] == 'S') {
				dfs(i+1, depth+1, som+1);
			}else {
				dfs(i+1, depth+1, som);
			}
			visited[r][c] = false;
		}
		
	}

	private static boolean isConnected() {
		boolean[][] bfsvisit = new boolean[5][5];
		Queue<int[]> que = new LinkedList<>();
		int sr = 0, sc = 0;
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				if(visited[r][c]) {
					sr = r;
					sc = c;
					break;
				}
			}
		}
		
		int count = 1;
		que.add(new int[] {sr, sc});
		bfsvisit[sr][sc] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(!check(nr, nc)) continue;
				if(bfsvisit[nr][nc]) continue;
				if(visited[nr][nc]) {
					que.add(new int[] {nr, nc});
					bfsvisit[nr][nc] = true;
					count++;
				}
			}
		}
		
		return count==7;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<5 && c>= 0 && c<5;
	}
}
