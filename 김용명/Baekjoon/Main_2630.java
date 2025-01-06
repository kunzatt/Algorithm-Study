import java.io.*;
import java.util.*;

public class Main_2630 {
	
	static int wcount, bcount;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(0, 0, N);
		System.out.println(wcount + "\n" + bcount);

	}

	static void check(int r, int c, int n) {
		
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[r+i][c+j] == 1) count++;
			}
		}
		
		// 첫번째 사이클에서는 사각형 전체가 0 인지 1인지 확인한다.
		// 아니면 그 후 사분면을 나눠 각 사분면 check를 수행한다.
		// 사분면을 안나누고 그냥 재귀를 하게 되면 큰 0또는1인 사각형의 작은 사각형 또한 카운트 할 수 있다.
		// n이 1이 되면 count가 무조건 0 아니면 1이 되게 된다.
		if(count == n*n) bcount++;
		else if(count == 0) wcount++;
		else {
			check(r, c, n/2);
			check(r, c+n/2, n/2);
			check(r+n/2, c, n/2);
			check(r+n/2, c+n/2, n/2);
		}
		
	}

}
