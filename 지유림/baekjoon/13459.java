import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13459_구슬탈출 {
	static int N, M;
	static char[][] map;
	static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static class Point {
		int rx, ry, bx, by, t;

		public Point(int rx, int ry, int bx, int by, int t) {
			super();
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		int bx, by, rx, ry;
		bx = by = rx = ry = 0; 
		
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				
				if(map[i][j] == 'R') {
					rx = i;
					ry = j;
					map[i][j] = '.'; // 현재 위치도 갈 수 있으니까 변경
				} else if(map[i][j] == 'B') {
					bx = i;
					by = j;
					map[i][j] = '.';
				} 
			}
		}

		bfs(rx, ry, bx, by);
	}
	

	
	static void bfs(int rx, int ry, int bx, int by) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(rx, ry, bx, by, 0));
		
		
		while(!que.isEmpty()) {

			Point p = que.poll();

			if(p.t > 10) {
				System.out.println(0);
				return;
			}
			
			
			if(map[p.bx][p.by]== 'O') continue;
			if(map[p.rx][p.ry]== 'O') {
				System.out.println(1);
				return;
			}
			
			
			for(int d = 0; d < 4; d++) {

				// blue
				bx = p.bx;
				by = p.by;
				
				while(true) {
					bx += drc[d][0];
					by += drc[d][1];
					
					if(map[bx][by] == '#') {
						bx -= drc[d][0];
						by -= drc[d][1];
						break;
					}
					
					if(map[bx][by] == 'O') {
						break;
					}
				}
				
				// red
				rx = p.rx;
				ry = p.ry;
				
				while(true) {
					rx += drc[d][0];
					ry += drc[d][1];
					
					if(map[rx][ry] == '#') {
						rx -= drc[d][0];
						ry -= drc[d][1];
						break;
					}
					
					if(map[rx][ry] == 'O') {
						break;
					}
				}
				
				
				// 빨간공 파란공 위치 같을 때
				if(rx == bx && ry == by && map[rx][ry] != 'O') {
					// 처음 위치와 현재 위치 비교해서 많이 움직인거 횟수 비교
					int red = Math.abs(p.rx - rx) + Math.abs(p.ry - ry);
					int blue = Math.abs(p.bx - bx) + Math.abs(p.by - by);
					
					if(red > blue) {	// red가 크면 더 많이 움직인거 -> 레드가 뒤에 있단거
						rx -= drc[d][0];
						ry -= drc[d][1];
					} else {
						bx -= drc[d][0];
						by -= drc[d][1];
					}
				}
				
				que.offer(new Point(rx, ry, bx, by, p.t+1));
				
			}
		}
	}
}
