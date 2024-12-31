import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2512 {
    
	static int N, M;
	static int[] budget;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        budget = new int[N];
        
        int max = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, budget[i]);
		}
        
        M = Integer.parseInt(br.readLine());
                
        int lo = 0;
        int hi = max;
        
        while (lo <= hi) {
        	int mid = (lo+hi)/2;
        	
        	int sum = 0;
        	for (int i = 0; i < N; i++) {
				if (budget[i] > mid) {
					sum += mid;
				} else {
					sum += budget[i];
				}
			}
        	
        	if (sum > M) {
        		hi = mid-1;
        	} else {
        		lo = mid+1;
        	}
        }
        
        System.out.println(hi);
        
    }
    
}
