import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			System.out.println(stackSolving(br.readLine()));
		}

	}
	
	public static String stackSolving(String str) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '(') {
				stack.push(c);
			}else if(stack.isEmpty()) {
				return "NO";
			}else {
				stack.pop();
			}
			
		}
		if(stack.empty()) {
			return "YES";
		}else {
			return "NO";
		}	
	}
}
