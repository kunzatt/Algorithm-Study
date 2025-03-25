package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2741 {
	
	static int N;
	static BufferedReader br;

	public static void main(String[] args) throws Exception {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			System.out.println(i);
		}
		

	}

}
