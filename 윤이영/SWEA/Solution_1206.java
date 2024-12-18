import java.util.Scanner;

public class Solution_1206 {
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		for(int t=1; t<=10; t++) {
			int N = sc.nextInt();
			int total = check(N);
			
			System.out.println("#"+t+" "+total);
		}
		
	}
	
	public static int check(int N) {
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int total = 0;
		for (int i = 2; i < arr.length - 2; i++) {
			int result = 0;
			int left = Math.max(arr[i-1], arr[i-2]);
			int right = Math.max(arr[i+1], arr[i+2]);

			if( ((arr[i] -left) > 0) && ((arr[i] - right) > 0)) {
				result = Math.min(arr[i] - left, arr[i] - right);
			}
			total += result;
		}
		
		return total;
	}
}
