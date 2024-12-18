import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(tempSum(arr, n, k));	// tempSum 메서드 적용

	}
	static int tempSum(int[] map, int a, int b) {
		int max;
		int prev = 0;
		
		// 배열의 0번째부터 b개의 숫자 합
		for (int i = 0; i < b; i++) {
			prev += map[i];
		}
		max = prev; // 합의 최댓값을 비교해야하기 때문에 max를 prev로 초기화
		
		for (int i = 1; i <= a-b; i++) {
			int c = prev - map[i-1] + map[i-1+b]; // 슬라이딩 윈도우, 기존의 합에서 하나 전꺼를 뺴고 하나 후를 더한다.
			max = Math.max(max, c); // 새로운 합과 기존 합 최댓값 비교
			prev = c; // 그 다음 합도 비교해야하기 때문에 prev를 c로 초기화
		}
		return max;
	}

}
