import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654 {
    
	static int K, N;
	static int[] lan;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lan = new int[K];
        
        long max = 0;
        for (int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lan[i]);
		}
        
        long lo = 0;
        long hi = max+1;
        
        while (lo < hi) {
        	long mid = (lo+hi)/2;
        	
        	int sum = 0;
        	for (int i = 0; i < K; i++) {
				sum += lan[i]/mid;
			}
        	
        	if (sum < N) {
        		hi = mid;
        	} else {
        		lo = mid+1;
        	}
        }
        
        System.out.println(lo-1);
        
    }
    
}
