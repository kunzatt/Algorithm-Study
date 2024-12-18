import java.util.Scanner;

public class Main_9663 {
	static int  N;
	static int[][] map;
	static boolean[] col;
	static boolean[] rd;
	static boolean[] ld;
	static int count;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		col = new boolean[N];
		rd = new boolean[N*2+1]; // 오른쪽 대각선에 수가 있는지 확인하기 위한 배열
		ld = new boolean[N*2+1]; // 왼쪽 대각선에 수가 있는지 확인하기 위한 배열
		count = 0;
		dfs(0);		// depth == row
		System.out.println(count);
	
	}

	private static void dfs(int r) {
		if(r == N) {
			count++;
			return;
		}
		
		for(int c=0; c<N; c++) {		// 들어갈 수 있는 c를 찾기
			if(col[c] || rd[r+c] || ld[r-c+N]) continue;
			col[c] = true;
			rd[r+c] = true;   // 오른쪽 대각선 
			ld[r-c+N] = true;  // 왼쪽 대각선
			dfs(r+1);
			col[c] = false;
			rd[r+c] = false;
			ld[r-c+N] = false;
		}
	}
}
