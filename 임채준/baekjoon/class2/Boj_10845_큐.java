package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_10845_큐 {
	
	static int N;
	static Deque<Integer> que;

	public static void main(String[] args) throws Exception {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    que = new LinkedList<>();
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < N; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        String command = st.nextToken();
	        if(command.equals("push")) {
	            int num = Integer.parseInt(st.nextToken());
	            que.offer(num);
	        } else if(command.equals("pop")) {
	            if(que.isEmpty()) {
	                sb.append(-1).append("\n");
	            } else {
	                sb.append(que.poll()).append("\n");
	            }
	        } else if(command.equals("size")) {
	            sb.append(que.size()).append("\n");
	        } else if(command.equals("empty")) {
	            if(que.isEmpty()) {
	                sb.append(1).append("\n");
	            } else {
	                sb.append(0).append("\n");
	            }
	        } else if(command.equals("front")) {
	            if(que.isEmpty()) {
	                sb.append(-1).append("\n");
	            } else {
	                sb.append(que.peek()).append("\n");
	            }
	        } else if(command.equals("back")) {
	            if(que.isEmpty()) {
	                sb.append(-1).append("\n");
	            } else {
	                sb.append(que.peekLast()).append("\n");
	            }
	        }
	    }
	    System.out.println(sb);
	}

}
