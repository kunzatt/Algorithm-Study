import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2343 {
    
	static int N, M;
	static int[] num;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	num = new int[N];
    	int maxTime = 0;
    	int allTime = 0;
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			maxTime = Math.max(maxTime, num[i]);
			allTime += num[i];
		}
    	
    	int lo = maxTime;
    	int hi = allTime;    	
    	
    	while (lo <= hi) {
    		int mid = (lo+hi)/2;
    		
    		int sum = 0;
        	int cnt = 0;
        	
    		for (int i = 0; i < N; i++) {
				if (sum+num[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += num[i];
			}
    		
    		if (sum > 0) cnt++;
    		
    		if (cnt > M) {
    			lo = mid+1;
    		} else {
    			hi = mid-1;
    		}
    	}
    	
    	System.out.println(lo);
    	
    }
}
