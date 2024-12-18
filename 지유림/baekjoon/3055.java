import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3055_탈출 {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[][] drc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static class Point {
        int r, c, time;

		public Point(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
    }
    static Queue<Point> que;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        que = new LinkedList<>();
        visited = new boolean[R][C];
        
        int sr = 0;
        int sc = 0;
        
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == '*') {
                	que.offer(new Point(i, j, 0));
                } else if(map[i][j] == 'S') {
                	sr = i;
                	sc = j;
                }
            }
        }

        int result = bfs(sr, sc);
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    static int bfs(int sr, int sc) {
        que.offer(new Point(sr, sc, 0));
        visited[sr][sc] = true;
        
        while(!que.isEmpty()) {
        	Point p = que.poll();
        	
        	if(map[p.r][p.c] == 'D') {
        		return p.time;
        	}
        	
        	if(map[p.r][p.c] == '*') {
        		for(int d = 0; d < 4; d++) {
            		int nr = p.r+drc[d][0];
            		int nc = p.c+drc[d][1];
            		
            		if(!check(nr, nc) || visited[nr][nc]) continue;
            		if(map[nr][nc] == 'D' || map[nr][nc] == 'X') continue;
            		
            		que.offer(new Point(nr, nc, p.time));
            		visited[nr][nc] = true;
            		map[nr][nc] = '*';
            	}
        	} else {
        		for(int d = 0; d < 4; d++) {
        			int nr = p.r+drc[d][0];
        			int nc = p.c+drc[d][1];
        			
        			if(!check(nr, nc) || visited[nr][nc]) continue;
        			if(map[nr][nc] == '*' || map[nr][nc] == 'X') continue;
        			
        			que.offer(new Point(nr, nc, p.time+1));
        			visited[nr][nc] = true;
        		}
        	}
        }
        return -1; // 도달 불가능
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
