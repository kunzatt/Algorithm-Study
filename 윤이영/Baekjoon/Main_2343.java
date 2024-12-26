import java.util.Scanner;

public class Main_2343 {
	static int n, m;
	static int[] arr;
	static int maxlesson, total;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		total = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			maxlesson = Math.max(maxlesson, arr[i]);
			total += arr[i];
		}
		
		int left = maxlesson;
		int right = total;
		int ans = total;
		
		// 이분 탐색
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(isAvailable(mid, m)) {	// 가능한지 확인
				ans = mid;
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		
		
		System.out.println(ans);
	}

	private static boolean isAvailable(int maxsize, int m) {
		int count = 1;	// 블루레이의 개수
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			if(sum + arr[i] > maxsize) {
				count++;	// 새로운 블루레이
				sum = arr[i];	// 현재 강의를 새로운 블루레이에 담는다.
				
				if(count > m) {
					return false;	// 개수를 초과할 경우, false 리턴
				}
			}
			else {
				sum += arr[i];
			}
		}
		
		return true;
	}
}
