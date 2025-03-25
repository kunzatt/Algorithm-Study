package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_10828_스택 {
	
	static int N;
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    stack = new Stack<>();
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < N; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        String command = st.nextToken();
	        
	        if(command.equals("push")) {
	            int num = Integer.parseInt(st.nextToken());
	            stack.push(num);
	        } else if(command.equals("pop")) {
	            if(stack.isEmpty()) {
	                sb.append(-1).append("\n");
	            } else {
	                sb.append(stack.pop()).append("\n");
	            }
	        } else if(command.equals("size")) {
	            sb.append(stack.size()).append("\n");
	        } else if(command.equals("empty")) {
	            if(stack.isEmpty()) {
	                sb.append(1).append("\n");
	            } else {
	                sb.append(0).append("\n");
	            }
	        } else if(command.equals("top")) {
	            if(stack.isEmpty()) {
	                sb.append(-1).append("\n");
	            } else {
	                sb.append(stack.peek()).append("\n");
	            }
	        }
	    }
	    System.out.println(sb);
	}

}
