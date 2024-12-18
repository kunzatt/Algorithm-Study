import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1941_소문난칠공주 {
	static char[][] map;
	static int[] seven;
	static boolean[][] visited;
	static int result;
	static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		visited = new boolean[5][5];
		seven = new int[7];
		
		
		for(int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		result = 0;
		dfs(0, 0);
		System.out.println(result);
	}
	
	static void dfs(int cnt, int start) {
		if(cnt == 7) {
			
			if(checkS() && bfs()) result++;
			
			return;
		} else {
			for(int i = start; i < 25; i++) {
				
				visited[i/5][i%5] = true;
				dfs(cnt+1, i+1);
				visited[i/5][i%5] = false;
			}
		}
	}
	
	static boolean checkS() {
		int count = 0;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(visited[i][j] && map[i][j] == 'S') {
					count++;
				}
				
				if(count >= 4) return true;
			}
		}
		
		
		return false;
	}
	
	static boolean bfs() {
		Queue<Point> que = new LinkedList<>();
		boolean[][] checkMap = new boolean[5][5];
		
		int x = 0; int y = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				checkMap[i][j] = visited[i][j];
				
				if(visited[i][j]) {
					x = i; 
					y = j;
				}
			}
		}
		
		que.offer(new Point(x, y));
		
		int count = 0; // 7 되는지 횟수세기
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r+drc[d][0];
				int nc = p.c+drc[d][1];
				
				// 범위체크 || false면 연결 안되어있는거임
				if(!check(nr, nc) || !checkMap[nr][nc]) continue;
				
				
				count++;
				checkMap[nr][nc] = false; // false로 변경
				que.offer(new Point(nr, nc));
			}
		}
		
		
		
		return count == 7;
	}
	
	
	
	static boolean check(int r, int c) {
		return r >= 0 && r < 5 && c >= 0 && c < 5;
	}
}
