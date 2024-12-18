import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int cnt = 0;

    // arr[i]가 있던 자리는 안가도 되니까 j가 i+1 ~
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(arr[i] + arr[j] == M) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		
		
	}
}
