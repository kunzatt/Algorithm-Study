import java.util.Scanner;

public class Main {
	static int N, ans;
	static int[][] arr;
	static int min = 987654321;
	static int max = 0, sum = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			min = Math.min(min, arr[i][0]);
			max = Math.max(max,  arr[i][0]);
		}
		
		int tmp, total;
		for(int i=min; i<=max; i++) {
			tmp = 0;
			for(int j=0; j<N; j++) {
				total = i - arr[j][1];
				//System.out.println(tmp);
				if(i <= arr[j][0]) {
					if(total > 0) {
						tmp += total;
					}
				}
			}
			
			if( sum < tmp) {
				ans = i;
				sum = tmp;
				//System.out.println(ans +" = "+ tmp);
			}
			
		}
		
		System.out.println(ans);
		
	}
}
