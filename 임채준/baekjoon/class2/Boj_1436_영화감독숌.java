package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Boj_1436_영화감독숌 {
	
	static int N, val, count;
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        val = 666;
        count = 1;
        
        while(count < N) {
            val++;
            if(String.valueOf(val).contains("666")) {
                count++;
            }
        }
        
        System.out.println(val);
    }
}