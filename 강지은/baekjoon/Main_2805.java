import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
	
    static int N, M;
    static long[] trees;
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        trees = new long[N];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
        
        Arrays.sort(trees);
        
        long lo = 0;
        long hi = trees[N-1];
        long mid = (lo+hi)/2;
        
        while (lo <= hi) {
        	long sum = 0;
        	for (int i = 0; i < N; i++) {
        		if (mid < trees[i]) {        			
        			sum += trees[i]-mid;
        		}
			}
        	
        	if (sum == M) break;
        	if (sum > M) {
        		lo = mid+1;
        	} else {
        		hi = mid-1;
        	}
        	
        	mid = (lo+hi)/2;
        }
        
        System.out.println(mid);
        
    }
}
