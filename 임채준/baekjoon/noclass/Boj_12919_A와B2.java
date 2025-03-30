package noclass;

import java.io.*;

public class Boj_12919_A와B2 {
	
	static String S, T;
	static int ans;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		ans = 0;
		check(T);
		System.out.println(ans);

	}

	private static void check(String line) {
		if (line.length() < S.length()) {
            return;
        }
		if(line.equals(S)) {
			ans = 1;
			return;
		}		
		if (line.charAt(line.length() - 1) == 'A') {
			String temp = "";
			for(int i = 0; i < line.length() - 1; i++) {
				temp += line.charAt(i);
			}
			check(temp);
        }
		if (line.charAt(0) == 'B') {
			String temp = "";
			for(int i = line.length() - 1; i >= 1; i--) {
				temp += line.charAt(i);
			}
			check(temp);
        }
				
	}

}
