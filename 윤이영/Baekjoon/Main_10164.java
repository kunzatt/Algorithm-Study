import java.util.Scanner;

public class Main_10164 {
	static int N, M, K;
	static int[][] dp;
	static int path;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		dp = new int[N][M];
		
		// K가 있는 경우와 없는 경우로 나눠서 풀이
		if(K==0) {
			path = getPath(0, 0, N-1, M-1);
		}
		else {
			int kr = (K-1) / M;
			int kc = (K-1) % M;
			path = getPath(0, 0, kr, kc) * getPath(kr, kc, N-1, M-1);
		}
		
		System.out.println(path);
	}

	private static int getPath(int sr, int sc, int er, int ec) {
		
		// dp배열 준비
		dp[sr][sc] = 1;
		
		// dp 계산  현재 칸 = 왼쪽칸 + 위쪽 칸
		for(int r=sr; r<=er; r++) {
			for(int c = sc; c<=ec; c++) {
				if( r > sr) dp[r][c] += dp[r-1][c];
				if( c > sc) dp[r][c] += dp[r][c-1];
			}
		}
		
		return dp[er][ec];
	}
}
