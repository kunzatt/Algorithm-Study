import java.io.BufferedReader;
import java.io.InputStreamReader;

// S->T를 만들려고 했더니 시간초과
// T->S를 만들어보기

public class Main_12904 {
	static String S;
	static String T;
	static int check = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		T = br.readLine();

		ChangeString(T.length(), T);
		System.out.println(check);
	}
	
	private static void ChangeString(int depth, String temp) {
		//System.out.println(temp);
		if(temp.length() == S.length()) {
			if(temp.equals(S)) {
				check = 1;
				return;
			}
			return;
		}
		int lastidx = temp.length()-1;
		if(temp.charAt(lastidx) == 'A') {
			ChangeString(depth-1, temp.substring(0, lastidx));
		}
		else {
			StringBuffer sb = new StringBuffer(temp.substring(0, lastidx));
			ChangeString(depth-1, sb.reverse().toString());
		}
		
	}
}



/*
 * 문자열의 뒤에 A를 추가한다.
문자열을 뒤집고 뒤에 B를 추가한다.
 */
