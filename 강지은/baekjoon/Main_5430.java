import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main_5430 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String com = br.readLine();
			int N = Integer.parseInt(br.readLine());
			
			Deque<Integer> deq = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(),"[,]");
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				deq.offer(num);
			}
			
			String ans = "";
			
			int len = com.length();
			boolean reverse = false;
			for (int i = 0; i < len; i++) {				
				if (com.charAt(i) == 'R') {
					reverse = !reverse;
				}
				
				if (com.charAt(i) == 'D') {
					if (deq.isEmpty()) {
						ans = "error";
						break;
					}
					
					if (reverse)
						deq.pollLast();
					else
						deq.poll();
				}
			}
			
			if (ans.equals("error"))
				System.out.println(ans);
			else {
				StringBuilder sb = new StringBuilder("[");
				if (reverse) {
					while (!deq.isEmpty()) {
						sb.append(deq.pollLast()+",");
					}
				} else {
					while (!deq.isEmpty()) {
						sb.append(deq.poll()+",");
					}
				}
				if (sb.length() > 2) {					
					sb.deleteCharAt(sb.length()-1);
				}
				sb.append("]");
				System.out.println(sb.toString());
			}
			
		}
		
	}

}
