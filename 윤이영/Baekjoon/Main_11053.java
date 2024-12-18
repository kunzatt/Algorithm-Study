import java.util.Scanner;

public class Main_11053 {
	static int[] dp;
	static int[] arr;
	static int N;
	static int max = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N];
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// bottom-up 방식
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			
			// i 이전의 원소들을 탐색하며 가장 긴 수열을 찾는다.
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && dp[i] < dp[j]+1) {
					// i번째 원소보다 작으면서 // dp배열에 저장된 수열의 길이는 긴 경우
					dp[i] = dp[j]+1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
