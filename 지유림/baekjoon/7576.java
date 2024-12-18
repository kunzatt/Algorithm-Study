import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static class Point {
		int x, y, c;

		public Point(int x, int y, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		Queue<Point> que = new LinkedList<>();
		
		int cnt = 0;
		boolean zeroCnt = true;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					que.offer(new Point(i, j, 0));
				} else if(map[i][j] == -1) {
					cnt++;
				} else if(map[i][j] == 0 && zeroCnt) {
					zeroCnt = false;
				} 
			}
		}
		

		
		
		if(zeroCnt) {	// 토마토가 다 익었으면 0 출력
			System.out.println(0);
		} else {
			System.out.println(bfs(que, (N*M-cnt)));
		}	// N*M 개수에서 cnt(-1의개수) 를 뺀 거
		
		
		
		
		
	}
	
	static int bfs(Queue<Point> que, int result) {
		int tomato = 0;
		
		while(!que.isEmpty()) {
			Point p = que.poll();

			for(int d = 0; d < 4; d++) {
				int nx = p.x+drc[d][0];
				int ny = p.y+drc[d][1];
				int nc = p.c;	// count
				
				if(!check(nx, ny)) continue;
				if(map[nx][ny] != 0) continue;
				
				que.offer(new Point(nx, ny, nc+1));
				map[nx][ny] = 1;
			}
			
			// que에 없으면, 토마토가 모두 익거나 or 익지못했거나
			// 최소 시간은 어쨌든 저장
			tomato = p.c;
			
		}
		
		// 토마토 다 익었는지 확인하기
		if(checkTomato(result)) {
			return tomato;
		} else {
			return -1;
		}
	}
	
	// 토마토 다 익었으면 true
	// 토마토 안 익은게 하나라도 있으면 false
	static boolean checkTomato(int result) {
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					count++;
				}
			}
		}
		
		return result == count;
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
