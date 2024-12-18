import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main2573_빙산 {
	static int N, M;
	static int[][] map;
	static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int time = 0;
		int count = 0;
		
		while(true) {
			
			bfs();
			time++;

			
			count = icebergCount();
			
			if(count >= 2) break;
			if(count == 0) {
				time = 0;
				break;
			}
		}
		
		bw.write(time + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 빙하 녹이는 bfs
	static void bfs() {
		// 초기화
		Queue<Point> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		
		// 0이 아닌것들 미리 넣어주기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					que.offer(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		
        while (!que.isEmpty()) {
            Point p = que.poll();
            int seaCount = 0; // 주변 바다 개수
            
            int nr = 0;
            int nc = 0;
            
            for (int d = 0; d < 4; d++) {
                nr = p.r + drc[d][0];
                nc = p.c + drc[d][1];

                if(!check(nr, nc) || visited[nr][nc]) continue;

                if(map[nr][nc] == 0) seaCount++; 
               
            }
            

            // 0보다 작으면 -> 방문체크 하기 때문에 copy 둘 필요 x
            if(map[p.r][p.c] - seaCount < 0) {
            	map[p.r][p.c] = 0;
            	
            } else {
            	map[p.r][p.c] -= seaCount;
            }
        }
    }
	
	// 빙산 세기
	static int icebergCount() {
		boolean[][] visit = new boolean[N][M];
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0 && !visit[i][j]) {
					dfs(i, j, visit);
					count++;
				}
			}
		}
		
		return count;
	}
	
	// 빙하덩어리 체크
	static void dfs(int r, int c, boolean[][] visit) {
		visit[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r+drc[d][0];
			int nc = c+drc[d][1];
			
			if(!check(nr, nc)) continue;
			
			if(map[nr][nc] != 0 && !visit[nr][nc]) {
				dfs(nr, nc, visit);
			}
			
		}
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
