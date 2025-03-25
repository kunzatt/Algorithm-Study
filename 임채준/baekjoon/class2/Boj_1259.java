package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1259 {
	
	static int len, mid, count;
	static String input, ans;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			input = br.readLine();
			ans = "no";
			if(input.equals("0")) break;
			len = input.length();
			mid = len / 2;
			count = 0;
			for(int i = 0; i < mid; i++) {
				if(input.charAt(i) != input.charAt(len - 1 - i)) count++;
			}
			if(count == 0) ans = "yes";
			System.out.println(ans);
		}

	}

}
