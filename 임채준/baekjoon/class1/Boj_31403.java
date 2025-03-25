package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_31403 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		System.out.println(A + B - C);
		
		String sA = String.valueOf(A);
        String sB = String.valueOf(B);
        String sC = String.valueOf(C);
        
        System.out.println(Integer.parseInt(sA + sB) - C);
        

	}

}
