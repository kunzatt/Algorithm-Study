import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main_1918 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(infixToPostfix(br.readLine()));

	}
	
	static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
	}
	
	static String infixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			if (c >= 'A') { 
				// 기존 중위 표기 -> 후위 표기는 숫자면 먼저 출력하지만
				// 이 문제는 A, B등 대문자 알파벳이기 때문에 char에서 'A'이상이면 먼저 출력하면 된다.
				postfix += c;
			}else if (c == '(') {
				stack.push(c);
			}else if (c == ')') {
				char popItem = stack.pop();
				while(popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			}else {
				while (!stack.isEmpty() && stack.peek() != '(' && 
						map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
		}
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}
		return postfix;
	}
}
