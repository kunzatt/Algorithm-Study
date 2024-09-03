import java.io.*;
import java.util.*;

public class Main_4963 {

	static int w, h, nr, nc;
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			
			for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
			
			System.out.println(count);			
		}

	}

	static void dfs(int r, int c) {

    	visited[r][c] = true;
    	
		for (int i = 0; i < 8; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			
			if (check() && !visited[nr][nc] && map[nr][nc] == 1) dfs(nr, nc);
		}
		
	}
	
	static boolean check() {
		return (nr >= 0 && nc >= 0 && nr < h && nc < w);
	} 

}
