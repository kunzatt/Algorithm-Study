import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20300 {
	static int N;
	static long [] arr;
	static long M = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken()); 
		}
		
		Arrays.sort(arr);
		
		if(N % 2 == 0) {
			for(int i=0; i<N/2; i++) {
				M = Math.max(M, arr[i]+arr[N-1-i]);
			}
		}
		else {
			M = arr[N-1];
			for(int i=0; i<N/2-1; i++) {
				M = Math.max(M, arr[i]+arr[N-2-i]);
			}
		}
		
		
		System.out.println(M);
	}
}
