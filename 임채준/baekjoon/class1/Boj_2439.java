package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2439 {
	
	static int N;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= N; i++) {
            
            for(int j = 0; j < N-i; j++) {
                sb.append(" ");
            }
            
            for(int j = 0; j < i; j++) {
                sb.append("*");
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}