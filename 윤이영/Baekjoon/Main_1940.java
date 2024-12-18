import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1940 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		boolean[] check = new boolean[N];	// 재료의 사용여부 체크하는 배열
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt =0;
		for(int i=0; i<N-1; i++) {
			if(check[i])	// 만약 사용했던 재료면 패스
				continue;
			for(int j=i+1; j<N; j++) {
				if(arr[i] + arr[j] == M) {
					cnt++;	
					check[i] = true;	// 재료 사용했으면 체크
					check[j] = true;
				}
			}
		}
		System.out.println(cnt);
	}

}
