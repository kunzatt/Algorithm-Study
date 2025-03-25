package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_9012_괄호 {
	
    static int N, count;
    static boolean valid;
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            count = 0;
            valid = true;      
            for(char c : line.toCharArray()) {
            	
                if(c == '(') {
                    count++;
                } else if(c == ')') {
                    count--;
                }
                
                if(count < 0) {
                    valid = false;
                    break;
                }
            }
            
            if(count != 0) {
                valid = false;
            }
            
            sb.append(valid ? "YES" : "NO").append('\n');
        }
        
        System.out.print(sb);
    }
}