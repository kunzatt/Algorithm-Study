import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][4];
		int[][] map = new int[1002][1002];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int r = arr[i][0]; r < (arr[i][0]+arr[i][2]); r++) {
				for (int c = arr[i][1]; c < (arr[i][1]+arr[i][3]); c++) {
					map[r][c] = i+1;
				}
			}			
		}
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int r = 0; r < 1002; r++) {
				for (int c = 0; c < 1002; c++) {
					if(map[r][c] == i) 
						sum += map[r][c];	
				}
			}			
			System.out.println(sum/i);
		}
	}

}
