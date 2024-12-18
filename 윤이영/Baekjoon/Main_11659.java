import java.util.Arrays;
import java.util.Scanner;

public class Main_11659 {
	
	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 누적합으로 바꾸기
		for(int i=1; i<=N; i++) {
			arr[i] = arr[i]+arr[i-1];
		}
		//System.out.println(Arrays.toString(arr));
		for(int i=0; i<M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			System.out.println(sumSE(s, e));
		}
	}
	private static int sumSE(int s, int e) {
		// TODO Auto-generated method stub
		return arr[e]-arr[s-1];
	}
}

/*

5 3
5 4 3 2 1
1 3
2 4
5 5

*/