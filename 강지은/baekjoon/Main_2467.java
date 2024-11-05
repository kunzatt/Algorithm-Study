import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2467 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] potion = new int[N];
        for (int i = 0; i < N; i++) {
			potion[i] = Integer.parseInt(st.nextToken());
		}
        
        Arrays.sort(potion);
        
        int lo = 0;
        int hi = N-1;
        int[] ans = {Integer.MAX_VALUE, 0, 0};
        
        while (lo<hi) {
        	int mix = potion[lo]+potion[hi];
        	
        	if (Math.abs(0-ans[0]) > Math.abs(0-mix)) {
        		ans[0] = mix;
        		ans[1] = potion[lo];
        		ans[2] = potion[hi];
        	}
        	
        	if (mix > 0) {
        		hi--;
        	} else {
        		lo++;
        	}
        }
        
        System.out.println(ans[1]+" "+ans[2]);
        
    }
    
}
