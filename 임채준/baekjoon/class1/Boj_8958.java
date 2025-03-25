package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_8958 {
	
	static int T, len, ans;
	static int[] score;
	static String input;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			ans = 0;
			input = br.readLine();
			char[] c = input.toCharArray();
			len = c.length;
			score = new int[len];
			if(c[0] == 'O') score[0] = 1;
			else score[0] = 0;
			ans += score[0];
			for(int i = 1; i < len; i++) {
				if(c[i] == 'O') score[i] = score[i - 1] + 1;
				else score[i] = 0;
				ans += score[i];
			}
			System.out.println(ans);
		}

	}

}
