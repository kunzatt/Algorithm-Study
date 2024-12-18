import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1961_숫자배열회전 {
	static int T, N;
	public static void main(String[] args) throws Exception {
		// 90도, 180도, 270도 회전
		// 90도를 1번, 2번, 3번 돌리는거로 생각 -> 90도 함수를 만들어서 반복해서 쓰자 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			int[][] origin = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					origin[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] nineO = ninety(origin);
			int[][] eightO = ninety(nineO);
			int[][] twoO = ninety(eightO);
			
			
			System.out.println("#" + t);
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					System.out.print(nineO[r][c]);
				}
				
				System.out.print(" ");
				
				for(int c = 0; c < N; c++) {
					System.out.print(eightO[r][c]);
				}
				
				System.out.print(" ");
				
				for(int c = 0; c < N; c++) {
					System.out.print(twoO[r][c]);
				}
				
				System.out.println();
			}
		
		}
		
	}
	
	// 90도 돌리는 함수
	static int[][] ninety(int[][] arr) {
		// 그려서 생각해보면 무언가 순서가 있는데
		// 0,0 <- 2,0
		// 0,1 <- 1,0
		// 0,2 <- 0,0
		// result[r][c] = arr[arr.length-1-c][r];
		int[][] result = new int[N][N];
		
		for(int r = 0; r < arr.length; r++) {
			for(int c = 0; c < arr.length; c++) {
				result[r][c] = arr[arr.length-1-c][r];
			}
		}
		
		return result;
	}
}
