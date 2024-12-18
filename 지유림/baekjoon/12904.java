import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12904_A와B {
	// dfs -> 시간초과..
	// S -> T가 아니라 T -> S로 가면서 줄여나가면 되지 않으까
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 문자열 뒤집기 편하게 하려고 StringBuilder 쓰기
		StringBuilder S = new StringBuilder(br.readLine());	
		StringBuilder T = new StringBuilder(br.readLine());
		
		
		// 조건 1. 문자열 뒤에 A 추가 -> A 제거
		// 조건 2. 문자열 뒤집고 뒤에 B 추가 -> 뒤가 B면, 제거하고 뒤집기
		
		int result = 0;
		
		while(true) {
			if(S.length() == T.length()) {
				if(S.toString().equals(T.toString())) result = 1;
				
				break;
					
			}
			 
			// A면 제거
			if(T.charAt(T.length()-1) == 'A') {
				T.deleteCharAt(T.length()-1);

			} else if(T.charAt(T.length()-1) == 'B') {	
				// 앞에가 B면 	제거하고 뒤집기
				T.deleteCharAt(T.length()-1);
				T.reverse();
			}
		}
		
		System.out.println(result);
	}
}
