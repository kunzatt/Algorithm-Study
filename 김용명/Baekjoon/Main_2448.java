import java.util.Scanner;

public class Main_2448 {
	
	static int[][] tgl;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		tgl = new int[N][2*N-1];	// 제일 작은 패턴을 보는게 아니라 큰 패턴을 봐야한다.
		pattern(0, N-1, N);		// N-1은 0~2N-1의 중앙값이다.
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2*N-1; j++) {
				sb.append(tgl[i][j] == 1?"*":" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}


	static void pattern(int r, int c, int n) {
		
		// 제일 작은 삼각형일때의 패턴
		// 사실상 노가다.
		if (n == 3) {
			tgl[r][c] = 1;
			tgl[r+1][c-1] = tgl[r+1][c+1] = 1;
			
			for (int i = -2; i <= 2; i++) {
				tgl[r+2][c+i] = 1;
			}
			
		}
		// 제일 작은 삼각형을 본격적인 패턴으로 어떻게 사용할 것인지
		else {
			pattern(r, c, n/2);		// 위 삼각형
			pattern(r+n/2, c-n/2, n/2);		// 왼쪽 삼각형
			pattern(r+n/2, c+n/2, n/2);		// 오른쪽 삼각형
		}
	}
	
	
}
