import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13398 {
    
	static int N;
	static int[] arr, sum1, sum2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sum1 = new int[N];
        sum2 = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
                
        sum1[0] = arr[0];
        
        int max = sum1[0];
        for (int i = 1; i < N; i++) {
			sum1[i] = Math.max(arr[i], sum1[i-1]+arr[i]);
			max = Math.max(max, sum1[i]);
		}
        
        sum2[N-1] = arr[N-1];
        for (int i = N-2; i >= 0; i--) {	
			sum2[i] = Math.max(arr[i], sum2[i+1]+arr[i]);
		}
        
        for (int i = 1; i < N-1; i++) {
			max = Math.max(max, sum1[i-1]+sum2[i+1]);
		}
                
        System.out.println(max);
        
    }
    
}
