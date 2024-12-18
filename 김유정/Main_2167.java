package algol0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2167 {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] sumMap;
	static int K;
	static int i, j, x, y;
	static int sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		sumMap = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				sumMap[n][m] = check(n-1,m) + check(n,m-1) - check(n-1,m-1) + map[n][m];
			}
		}

		// 연산
		K = Integer.parseInt(br.readLine()); // 경우의 수
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			sum = sumMap[x-1][y-1] - check(x-1,j-2) - check(i-2,y-1) + check(i-2,j-2);
			System.out.println(sum);
		}		
	}

	private static int check(int n, int m) {
		if (n >= 0 && n < N && m >= 0 && m < M)
			return sumMap[n][m];
		return 0;
	}
}
