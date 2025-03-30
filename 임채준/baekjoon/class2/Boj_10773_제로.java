package class2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_10773_제로 {
	
	static int N;
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				stack.push(num);
			} else {
				stack.pop();
			}
		}
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);

	}

}
