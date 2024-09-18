import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
	static int N, M;
	static int[] arr;
	static int maxh;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int left = 0;
		int right = arr[N-1];
		
		while (left <= right) {
			int mid = (left+right)/2;	// 나무를 자르는 높이(기준)
			long sum = 0;
			for(int i=0; i<N; i++){
				if(arr[i] > mid) {
					sum += arr[i]-mid;
				}
			}
			
			if(sum >= M) {	// 너무 많이 가져간 경우 - mid 값을 높여줘야 한다.
				// 탐색의 범위를 오른쪽으로
				left = mid+1;
			}else if(sum <M) {			// 너무 적게 가져간 경우: mid 값을 낮춰줘야한다.
				// 탐색의 범위를 왼쪽으로
				right = mid-1;
			}
		}
		
		// left가 right보다 커질 때 종료됨.
		// 따라서, right값은 조건을 만족하는 마지막 mid값이다.
		
		System.out.println(right);
			
	}
	
	
	
	
}
