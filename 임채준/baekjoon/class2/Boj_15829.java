package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_15829 {
	
	static int L;
	static final int M = 1234567891;
	static long r, ans;
	static String input;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        input = br.readLine();
        ans = 0;
        r = 1;
        
        for(int i = 0; i < L; i++) {
            long a = input.charAt(i) - 'a' + 1;
            ans = (ans + (a * r) % M) % M;
            r = (r * 31) % M;
        }
        
        System.out.println(ans);
    }
}