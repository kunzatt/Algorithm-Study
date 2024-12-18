import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2812 {
	
	static int N, K;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		char[] tmp = br.readLine().toCharArray();
		
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			int num = tmp[i]-'0';
			
			if (stack.isEmpty() || cnt==K) {
				stack.push(num);
				continue;
			}
			
			while (!stack.isEmpty() && num > stack.peek()) {
				stack.pop();
				cnt++;
				
				if (cnt==K) break;
			}
			
			stack.push(num);
		}
		
		while (cnt < K) {
			stack.pop();
			cnt++;
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.reverse().toString());
	}
}
