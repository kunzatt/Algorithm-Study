import java.util.Arrays;
import java.util.Scanner;

public class Main_12852 {
	static int X;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		X = sc.nextInt();
		
		int dp[] = new int[X+1];	//연산 횟수의 최솟값
		int trace[] = new int[X+1];	// 연산 이전의 숫자를 담을 배열
		
		// 졍수까지 연산을 하면서 연산 횟수를 최소인 값으로 계속 업데이트해줌
		// 
		for(int i=2; i<=X; i++) {
			dp[i] = dp[i-1]+1;
			trace[i] = i-1;
			if(i%2 == 0 && dp[i] > dp[i/2] +1) {
				dp[i] = dp[i/2]+1;
				trace[i] = i/2;
			}
			if(i%3 == 0 && dp[i] > dp[i/3] + 1) {
				dp[i] = dp[i/3] + 1;
				trace[i] = i/3;
			}
			
//			System.out.println("DP   : "+Arrays.toString(dp));
//			System.out.println("Trace: "+Arrays.toString(trace));
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dp[X] + "\n");
		while(X > 0) {
			sb.append(X + " ");
			X = trace[X];
		}
		System.out.println(sb);
	}
}
