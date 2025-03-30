package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4153 {
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (a == 0 && b == 0 && c == 0) break;
            
            int max = Math.max(Math.max(a, b), c);
            int min = Math.min(Math.min(a, b), c);
            int mid = a + b + c - max - min;
            
            if (min * min + mid * mid == max * max) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        
        System.out.print(sb);
    }
}