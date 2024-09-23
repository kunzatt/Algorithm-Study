import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_6198 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();		
		
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			int bd = Integer.parseInt(br.readLine());
			
			while (!stack.isEmpty()) {
				if (stack.peek() > bd) {
					cnt += stack.size();
					break;
				}
				
				if (stack.peek() <= bd) {
					stack.pop();
				}
			}
			
			stack.push(bd);
		}
		
		System.out.println(cnt);
		
	}

}
