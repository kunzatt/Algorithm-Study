import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2630_색종이만들기 {
	static int N;
	static int[][] map;
	static int blue;
	static int white;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		blue = 0;
		white = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void dfs(int r, int c, int size) {
		
		if(check(r, c, size)) {
			if(map[r][c] == 0) {
				white++;
			} else if(map[r][c] == 1) {
				blue++;
			}
			
			return;
		} 
		
		int hSize = size / 2;
		
		
		dfs(r, c, hSize); // 2사분면
		dfs(r, c+hSize, hSize); // 1사분면
		dfs(r+hSize, c, hSize); // 3사분면
		dfs(r+hSize, c+hSize, hSize); // 4사분면
	}
	
	static boolean check(int r, int c, int size) {
		
		for(int i = r; i < r+size; i++) {
			for(int j = c; j < c+size; j++) {
				if(map[r][c] != map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
