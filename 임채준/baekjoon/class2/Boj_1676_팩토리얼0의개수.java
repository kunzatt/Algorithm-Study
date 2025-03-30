package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1676_팩토리얼0의개수 {
	
    static int N, count;
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        count = 0;

        for (int i = 5; i <= N; i *= 5) {
            count += N / i;
        }
        
        System.out.println(count);
    }
}