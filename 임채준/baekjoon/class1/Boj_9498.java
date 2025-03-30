package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_9498 {
	
	static int N;
	static BufferedReader br;

	public static void main(String[] args) throws Exception {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		if(N >= 90) System.out.println("A");
		else if(N >= 80) System.out.println("B");
		else if(N >= 70) System.out.println("C");
		else if(N >= 60) System.out.println("D");
		else System.out.println("F");
		
	}

}
