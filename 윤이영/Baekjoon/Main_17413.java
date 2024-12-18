import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] sen = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		String Ans = "";	// 정답 배열
		
		for(int i=0; i<sen.length; i++) {
			// 스택 이용
			if(sen[i] == ' ') {
				while(!stack.isEmpty()) {
					Ans += stack.pop();
				}
				Ans+= ' ';
			}
			else if(sen[i] == '<') {	// '<'가 입력될 경우에는 뒤집지 않음
				while(!stack.isEmpty()) {
					Ans += stack.pop();	// 스택 비워주기
				}	
				while(sen[i] != '>') {	// '>'가 입력될 때까지...
					Ans += sen[i++];
				}
				Ans+= '>';
			}
			else {
				stack.push(sen[i]);
			}
		}
		while(!stack.isEmpty()) {
			Ans += stack.pop();
		}

		System.out.println(Ans);
	}
}
