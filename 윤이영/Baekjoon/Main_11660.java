import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660 {
	
	static int N,M;
	static int[][] arr;
	static int x1, x2, y1, y2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 누적합 2차원 배열 만들기
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				arr[r][c] = arr[r][c]+ arr[r-1][c] + arr[r][c-1] - arr[r-1][c-1];
			}
		}
		
		
		// 구간합 구하기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			int sum = getSum(x1,y1,x2,y2);
			System.out.println(sum);
		}
		
	}
	private static int getSum(int x1, int y1, int x2, int y2) {
		int sum = arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1]+ arr[x1-1][y1-1];
		return sum;
	}
	
}

/*

4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4



*/