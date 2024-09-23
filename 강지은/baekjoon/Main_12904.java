import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12904 {
	
	static String S, T;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		S = br.readLine();
		T = br.readLine();
		sb.append(T);
		
		while (sb.length() > S.length()) {
			int size = sb.length();
			
			// 마지막 글자가 A일 경우
			if (sb.charAt(--size) == 'A') {
				sb.deleteCharAt(size);
			}
			// 마지막 글자가 B일 경우
			else {
				sb.deleteCharAt(size);
				char[] tmp = new char[size];
				for (int i = 0; i < tmp.length; i++) {
					tmp[i] = sb.charAt(size-1-i);
				}
				
				sb.setLength(0);
				for (int i = 0; i < tmp.length; i++) {
					sb.append(tmp[i]);
				}
				
			}
			
		}
		
		if (sb.toString().equals(S)) System.out.println(1);
		else System.out.println(0);
		
	}

}
