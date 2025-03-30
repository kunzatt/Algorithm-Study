package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1874_스택수열 {
	
    static int n, cur;
    static Stack<Integer> stack = new Stack<>();
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());       
        StringBuilder sb = new StringBuilder();
        cur = 1;
        boolean pos = true;
        
        for(int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            while(cur <= target) {
                stack.push(cur++);
                sb.append("+\n");
            }
            if(!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                pos = false;
                break;
            }
        }
        if(pos) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}