package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1008 {
	
	static double A, B;
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		A = Double.parseDouble(st.nextToken());
		B = Double.parseDouble(st.nextToken());
		System.out.println(A / B);

	}

}
