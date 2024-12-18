import java.util.Scanner;

// 1로 만들기 2를 풀기 전에 DP이해를 위해 풀어본 문제

public class Main_1463 {
	static int X;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		X = sc.nextInt();
		
		int dp[] = new int[X+1];	//연산 횟수의 최솟값
		
		for(int i=2; i<=X; i++) {
			dp[i] = dp[i-1]+1;
			if(i%2 == 0 && dp[i] > dp[i/2] +1) {
				dp[i] = dp[i/2]+1;
			}
			if(i%3 == 0 && dp[i] > dp[i/3] + 1) {
				dp[i] = dp[i/3] + 1;
			}			
//			System.out.println("DP   : "+Arrays.toString(dp));

		}
		
		System.out.println(dp[X]);
	}
}
