import java.util.Scanner;

public class Main {
	static int N, S;
	static int[] arr;
	static int ans = 987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 투포인터
		int s =0,  e = 0;
		int sum = arr[0];
		int len = 1;
		if(sum >= S) {
			System.out.println(len);
			return;
		}
		
		while(s < N && e < N) {
			// 총 합이 S보다 작은 경우 -> e++
			if(sum < S) {
				e++;
				if(e >= N) break;
				sum += arr[e];
				len++;
			}
			else {	// 총 합이 S를 만족한 경우
				sum -= arr[s];
				s++;
				len--;
			}
			//System.out.println(arr[s]+" "+arr[e]+" :"+sum +" "+len);
			if(sum >= S) {
				ans = Math.min(ans, len);
			}
		}
		
		if(ans == 987654321) {
			ans = 0;
		}
		
		System.out.println(ans);
		
	}
}
