import java.util.Scanner;

public class Main_1535 {
	static int N;
	static int[] happy;
	static int[] life;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		happy = new int[N+1];
		life = new int[N+1];
		dp = new int[N+1][100];
		
		for(int i=1; i<=N; i++) {
			life[i] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {
			happy[i] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {	// 사람을 돌면서
			for(int j=1; j<100; j++) {	// 체력의 한계를 돌면서
				if(life[i] <= j) {
					// i번째 사람을 만나지 않는 경우 vs i번째 사람을 만나기 위해 체력 w[i]를 사용하고, 얻는 기쁨
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-life[i]]+happy[i]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[N][99]);
		
	}
}
