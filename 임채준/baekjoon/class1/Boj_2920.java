package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2920 {
	
	static String input, ans;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		if(input.equals("1 2 3 4 5 6 7 8")) ans = "ascending";
		else if(input.equals("8 7 6 5 4 3 2 1")) ans = "descending";
		else ans = "mixed";
		System.out.println(ans);

	}

}
