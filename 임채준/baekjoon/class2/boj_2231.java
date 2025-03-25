package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2231 {
	
	static int N, num, sum, ans;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = 0;
        
        for(int i = 1; i < N; i++) {
        	sum = i;
            num = i;

            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if(sum == N) {
                ans = i;
                break;
            }
        }
        
        System.out.println(ans);
    }
}