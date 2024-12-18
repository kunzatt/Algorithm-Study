import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, X;
	static int[] nArr;
	static int[] results;
	
	// 슬라이딩윈도우
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		nArr = new int[N];
		results = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int sum = 0;
		
		// 윈도우 크기만큼 다 더하기
		for(int i = 0; i < X; i++) {
			sum += nArr[i];
		}
		
		// 처음 나온 것도 더해주기!
		results[X - 1] = sum;
		
		int num = sum;
		// 윈도우 옮기면서 최대값 찾기
		for(int i = X; i < N; i++) {
			num += nArr[i] - nArr[i - X];
			results[i] = num;
			sum = Math.max(sum, num);
		}
        
		if(sum == 0) {
			System.out.println("SAD");
		} else {
			for(int i = 0; i < results.length; i++) {
				if(sum == results[i]) cnt++;
			} 
			
			System.out.println(sum);
			System.out.println(cnt);
		}
	}
}
