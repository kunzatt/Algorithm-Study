import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1959_두개의숫자열 {
	static int T, N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int[] max;
			int[] min;
			if(N > M) {
				max = new int[N];
				min = new int[M];
				
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < N; i++) {
					max[i] = Integer.parseInt(st.nextToken());
				}
				
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < M; i++) {
					min[i] = Integer.parseInt(st.nextToken());
				}
				
				
			} else {
				max = new int[M];
				min = new int[N];
				
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < N; i++) {
					min[i] = Integer.parseInt(st.nextToken());
				}
				
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < M; i++) {
					max[i] = Integer.parseInt(st.nextToken());
				}
			}

			


			
			int move = Math.abs(N - M) + 1;
			int multiple = 0;
			int sum = 0;
			
			int maxNum = 0;
			for(int i = 0; i < move; i++) {
				sum = 0;
				for(int j = 0; j < min.length; j++) {
					multiple = min[j] * max[i+j];
					sum += multiple;
				}
				
				maxNum = Math.max(maxNum, sum);
			}
			
			System.out.println("#" + t + " " + maxNum);
			
		}
	}
}
