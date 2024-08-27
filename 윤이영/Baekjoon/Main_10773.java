import java.util.Scanner;
import java.util.Stack;

public class Main_10773 {
	static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		K = sc.nextInt();
		for(int i=0; i<K; i++) {
			int N = sc.nextInt();
			if(N == 0) {
				if(stack.isEmpty()) continue;
				stack.pop();
			}
			else {
				stack.push(N);
			}
		}
		int total = 0;
		for(Integer s: stack) {
			total += s;
		}
		
		System.out.println(total);
	}

}
