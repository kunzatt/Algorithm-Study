import java.io.*;
import java.util.*;
 
public class Main_2004 {
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int tcount = sol(n, 2) - sol(m, 2) - sol(n - m, 2);
        int fcount = sol(n, 5) - sol(m, 5) - sol(n - m, 5);
        
        System.out.println(Math.min(tcount, fcount));
        
    }
    
    private static int sol(int n, int k) {
        int cnt = 0;
        
        while(n >= k) {
            cnt += n / k;
            n /= k;
        }
        
        return cnt;
    }
}