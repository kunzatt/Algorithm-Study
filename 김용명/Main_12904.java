import java.io.*;
import java.util.*;

public class Main_12904 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		sb.append(T);
		
		while (S.length() < sb.length()) {
			if (sb.charAt(sb.length() - 1) == 'A') change1(sb);
			else if (sb.charAt(sb.length() - 1) == 'B') change2(sb);
		}
		
		if (sb.toString().equals(S)) System.out.println(1);
		else System.out.println(0);

	}

	static void change1(StringBuilder sb) {
		
		sb.deleteCharAt(sb.length()-1);
		
	}
	
	static void change2(StringBuilder sb) {
		
		sb.reverse();
		sb.deleteCharAt(0);
		
	}

}
