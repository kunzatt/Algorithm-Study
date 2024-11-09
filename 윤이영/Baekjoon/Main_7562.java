import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7562 {
	static int T;
	static int l, c, r, ec, er;
	static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			l = sc.nextInt();
			map = new int[l][l];
			
			r = sc.nextInt();
			c = sc.nextInt();	// 시작 위치
			er = sc.nextInt();
			ec = sc.nextInt();	// 목표 위치
			
			int min = bfs(r, c);
			System.out.println(min-1);
		}
		
	}


	private static int bfs(int sr, int sc) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {sr, sc});
		map[sr][sc] = 1;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			if(r == er && c == ec) {
				return map[r][c];
			}
			
			for(int d=0; d<8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == 0 ) {
					map[nr][nc] = map[r][c] + 1;
					que.add(new int[] {nr, nc});
				}
				
			}
			
		}
		
		return Integer.MAX_VALUE;
	}


	private static boolean check(int r, int c) {
		return r>= 0 && r<l && c>=0 && c<l;
	}
}
