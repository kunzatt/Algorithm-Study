import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1940 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N-1; i++) {		// 맨 뒤 숫자를 더해야하기 때문에 배열의 뒤-1까지만 순회 
			for (int j = i+1; j < N; j++) {		// i보다 뒤에 있는 수들 중 하나를 더해야함.
				if (arr[i] + arr[j] == M) {
					count++;
				}
			}
		}
		System.out.println(count);
		
	}

}
