package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2292 {
	
    static int N, count, range;
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        count = 1;
        range = 1;
       
        while(range < N) {
            range += (6 * count);
            count++;
        }
        
        System.out.println(count);
    }
}