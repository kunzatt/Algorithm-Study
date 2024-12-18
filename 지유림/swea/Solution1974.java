import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1974_스도쿠검증 {
	static int T;
	static int N = 9;
	static int[][] sudoku;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		sudoku = new int[N][N];
		
		for(int t = 1; t <= T; t++) {
			
			for(int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int c = 0; c < N; c++) {
					sudoku[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 1;
			
			// 행, 열 같이 확인
			for(int r = 0; r < N; r++) {
				int[] rowFlag = new int[N + 1];
				int[] colFlag = new int[N + 1];
				for(int c = 0; c < N; c++) {
					if(colFlag[sudoku[r][c]] == 0 && rowFlag[sudoku[c][r]] == 0) {
						colFlag[sudoku[r][c]]++;
						rowFlag[sudoku[c][r]]++;
					} else {
						result++;
						break;
					}
				}
			}
			
			
			
			// 3차원배열 이용해서 3x3 확인하기
			boolean[][][] flag = new boolean[3][3][10];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					int num = sudoku[r][c];
					
					int i = r / 3;
					int j = c / 3;
					
					if(flag[i][j][num]) {
						result++; 
						break;
					} else {
						flag[i][j][num] = true;
					}
				}
			}
			
			if(result > 1) result = 0;
			System.out.println("#" + t + " " + result);
	
		}
	}
}
