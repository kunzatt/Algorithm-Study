import java.io.*;
import java.util.*;

public class Main {
	static int K, N;
    static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		
		for(int i = 0; i < K; i++) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) stack.pop();
			else stack.push(N);
		}
		
		int sum = 0;
		
		while(!stack.empty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}

}
