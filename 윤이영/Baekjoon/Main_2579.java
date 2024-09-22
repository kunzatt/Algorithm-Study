import java.util.Arrays;
import java.util.Scanner;

public class Main_2579 {
	static int S;
	static int[] stairs;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();
		stairs = new int[301];
		dp = new int[301];
		
		for(int i=0; i<S; i++) {
			stairs[i] = sc.nextInt();
		}
		
		
		dp[0] = stairs[0];
		dp[1] = stairs[0]+stairs[1];
		dp[2] = stairs[2] + Math.max(stairs[0],stairs[1]);

		for(int i = 3; i<S; i++) {
			dp[i] = stairs[i] + Math.max(stairs[i-1]+ dp[i-3], dp[i-2]);
		}
		
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[S-1]);			
	
		
	}

}


// n == 2 (stairs[0]+stairs[2]) || (stairs[1] + stairs[2]);
// n == 3 (stairs[3] + stairs[2] + dp[0]) ||  (stairs[3]+dp[1]) ;
// n == 4 (stairs[4] +stairs[3]+ dp[1]) || (stairs[4]+ dp[2])