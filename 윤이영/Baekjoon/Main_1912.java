import java.util.Scanner;

public class Main_1912 {
	static int n;
	static int[] arr;
	static int[] dp;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		dp = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		max = dp[0] = arr[0];
		
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(arr[i], arr[i]+dp[i-1]);
			max = Math.max(max, dp[i]);
		
		}
		
		System.out.println(max);
	}
}
