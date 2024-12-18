import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, K, T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int[][] puzzle = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for( int c = 0; c < N; c++) {
					puzzle[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			

			// 횟수 세기
			int cnt = 0;
			int result = 0;
			
			
			// 행 순회
			for(int r = 0; r < N; r++) {
				cnt = 0;
				for(int c = 0; c < N; c++) {
					if(puzzle[r][c] == 1) {
						cnt++;
					} else {
						cnt = 0;
					}
					
					if(cnt == K) {
						// 마지막 칸인지 확인
						if(c == N-1) {
							result++;
							cnt = 0;
						} else {
							// 마지막 칸 아니면 뒤에있는 칸이 0인지 확인
							if(puzzle[r][c+1] == 0) {
								result++;
								cnt = 0;
							}
						}
					}
				}
			}
			
			
			// 열 순회
			for(int c = 0; c < N; c++) {
				cnt = 0;
				for(int r = 0; r < N; r++) {
					if(puzzle[r][c] == 1) {
						cnt++;
					} else {
						cnt = 0;
					}
					
					if(cnt == K) {
						if(r == N-1) {
							result++;
							cnt = 0;
						} else {
							if(puzzle[r+1][c] == 0) {
								result++;
								cnt = 0;
							}
						}
					}
				}
			}
			

			System.out.println("#" + t + " " + result);
		}
		
	}
}
