package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2753 {
	
	static int N;
	static BufferedReader br;


	public static void main(String[] args) throws Exception {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N % 4 == 0 && (N % 100 != 0 || N % 400 == 0)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

}
