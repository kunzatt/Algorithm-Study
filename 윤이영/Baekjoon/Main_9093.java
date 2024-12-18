import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_9093 {
	static int N;
	static char[] sen;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<N; i++) {
			StringBuilder sb = new StringBuilder();
			
			sen = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			String S = "";
			for(int j=0; j<sen.length; j++) {
				if(sen[j] == ' ') {
					while(!stack.isEmpty()) {
						S+=stack.pop();
					}
					S += ' ';
				}
				else stack.push(sen[j]);
			}
			while(!stack.isEmpty()) {
				S+=stack.pop();
			}
			System.out.println(S);
		}

	}
}
