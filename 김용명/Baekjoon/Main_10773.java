import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
			int K = Integer.parseInt(br.readLine());
		
			for(int j = 0; j < K; j++) {
				int number = Integer.parseInt(br.readLine());	
			
				if(number == 0) {
					stack.pop();
				}
				else {
					stack.push(number);
				}
			}
			int sum = 0;
		
			for(int s : stack) {
				sum += s;
			}
			System.out.println(sum);	
	}
}
