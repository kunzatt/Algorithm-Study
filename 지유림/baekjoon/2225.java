import java.util.Scanner;

public class Main2225_합분해 {
	static int N, K;
	static int[][] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		nums = new int[N+1][K+1];
	
		for(int i = 0; i < N+1; i++) {
			nums[i][1] = 1;
		}
		
		for(int i = 0; i < K+1; i++) {
			nums[0][i] = 1;
		}
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < K+1; j++) {
				nums[i][j] = (nums[i][j-1] + nums[i-1][j]) % 1000000000;
			}
		}
		
		System.out.println(nums[N][K]);
		
	}
	
}
