import java.util.Scanner;
import java.util.Stack;

// 1918. 후위 표기식 / 골드2 / 1시간 40분
// 스택을 활용해 적절한 조건에 맞게 pop & push 해서 풀 수 있는 문제
// 스택 문제의 핵심은 어떨 때 pop 하고 어떨 때 push 해야할 지 그걸 생각할 수 있는 능력을 키워야할 듯..
public class Main {
	static String lowOp = "+-";
	static String highOp = "*/";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				sb.append(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				while (stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else if (s.charAt(i) == '(') {
				stack.add(s.charAt(i));
			} else if (lowOp.contains(s.charAt(i) + "")) {
				while (!stack.isEmpty() && (highOp.contains(stack.peek() + "") || lowOp.contains(stack.peek() + ""))) {
					sb.append(stack.pop());
				}
				stack.add(s.charAt(i));
			} else if (highOp.contains(s.charAt(i) + "")) {
				while (!stack.isEmpty() && highOp.contains(stack.peek() + "")) {
					sb.append(stack.pop());
				}
				stack.add(s.charAt(i));
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
