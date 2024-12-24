import java.util.Scanner;

public class Main_13398 {
	static int n;
	static int[] arr;
	static int[][] dp;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		dp = new int[n][2];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int ans = arr[0];
		dp[0][0] = arr[0];
		dp[0][1] = arr[0];
		
		for(int i=1; i<n; i++) {
			// 원소를 제거하지 않는 배열
			dp[i][0] = Math.max(arr[i], dp[i-1][0]+arr[i]);
			
			// i번 원소를 제거하는 경우 
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i] );
			
			// 최대값 찾기
			ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
		}
		
		System.out.println(ans);
	}
}
