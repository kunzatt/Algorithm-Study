import java.io.*;
import java.util.*;

public class Main_10799 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		
		int ans = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push('(');
				continue;
			}
			if (str.charAt(i) == ')') {
				stack.pop();				
				if (str.charAt(i - 1) == '(') {
					ans += stack.size();
				}else ans++;
			}
		}
		
		System.out.println(ans);

	}

}
