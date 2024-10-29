import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {

	static int N;
	static int[] num;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int lo = 0;
			int hi = N-1;
			
			while (true) {
				if (i==lo) lo++;
				if (i==hi) hi--;
				
				if (lo >= hi) break;
				
				int sum = num[lo]+num[hi];
				
				if (num[i] == sum) {
					cnt++;
					break;
				}
				
				if (num[i] <= sum) {
					hi--;
				} else {
					lo++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}	

}
