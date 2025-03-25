package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_27866 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();
		int n = Integer.parseInt(br.readLine());
		System.out.println(c[n - 1]);
	}

}
