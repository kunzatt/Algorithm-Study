import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1226 {
	static int T;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			T = Integer.parseInt(br.readLine());
			map = new int[16][16];
			visited = new boolean[16][16];
			
			for(int i=0; i<16; i++) {
				String tmp = br.readLine();
				for(int j=0; j<16; j++) {
					map[i][j] = tmp.charAt(j) - '0';
				}
			}	// 입력 끝
			
			
			for(int r=0; r<16; r++) {
				for(int c=0; c<16; c++) {
					if(map[r][c] == 2) {
						if(bfs(r,c)) {
							System.out.println("#"+T+" "+1);
						}
						else {
							System.out.println("#"+T+" "+0);
						}
					}
				}
			}
			
		}
	}

	private static boolean bfs(int sr, int sc) {
		Queue<int[] > que = new LinkedList<int[]>();
		que.add(new int[] {sr,sc});
		visited[sr][sc] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
		
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c + dc[d];
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == 0) {
					que.add(new int[] {nr, nc});
					visited[nr][nc] = true;;
				}
				else if(map[nr][nc] == 3) {
					return true;
				}
			}
		}
		
		
		return false;
		
	}

	private static boolean check(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr >= 0 && nr <16 && nc >= 0 && nc <16;
	}

}
