import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053 {
	
	static int A;
	static int[] arr, cnt;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		A = Integer.parseInt(br.readLine());
		arr = new int[A];
		cnt = new int[A];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < A; i++) {
			int num = arr[i];
			for (int j = 0; j < i; j++) {
				if (num > arr[j])
					cnt[i] = Math.max(cnt[j]+1, cnt[i]);
			}
		}
		
		int max = 0;
		for (int i = 0; i < A; i++) {
			max = Math.max(max, cnt[i]);
		}
	
		System.out.println(max+1);
		
	}
	
}
