import java.util.Scanner;

public class Solution_2005 {
	static int T;
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			for(int r = 0; r<N; r++)
				arr[r][0] = 1;
			
			for(int r = 1; r<N; r++) {
				arr[r][0] = 1;
				for(int c = 1; c<=r; c++) {
					if(r-1 < 0 || c-1 <0)
						continue;
					if(c==r) {
						arr[r][c] = 1;
					}
					else
						arr[r][c] = arr[r-1][c-1] + arr[r-1][c];
				}
				
			}
			
			
			System.out.println("#"+t);
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					if(arr[r][c] == 0)
						continue;
					System.out.print(arr[r][c]+" ");
				}
				System.out.println();
			}
		}
		
	}
}
