import java.io.*;
import java.util.*;

public class Main_3109 {
	
	static int R, C, count;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		count = 0;
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == '.') map[i][j] = 0;
				if (str.charAt(j) == 'x') map[i][j] = 1;
			}
		}
		
		for (int i = 0; i < R; i++) {
			if (dfs(i, 0)) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}

	static boolean dfs(int r, int c) {
		
		map[r][c] = 5;
		
		if(c == C-1) 
			return true;
		
		if(r > 0 && map[r-1][c+1] == 0) 
			if(dfs(r-1, c+1))
				return true;
		
		if(map[r][c+1] == 0) 
			if(dfs(r, c+1))
				return true;
		
		if(r+1 < R && map[r+1][c+1] == 0) 
			if(dfs(r+1, c+1))
				return true;
		return false;
	}
}
