package noclass;

import java.io.*;
import java.util.*;

public class Boj_2896_무알콜칵테일 {
	
	static int A, B, C, I, J, K;
	static double min;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		I = Integer.parseInt(st.nextToken());
		J = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		double X = (double) A / I;
		double Y = (double) B / J;
		double Z = (double) C / K;
		
		min = Math.min(X, Math.min(Y, Z));
		
		double X1 = A - I * min;
		double Y1 = B - J * min;
		double Z1 = C - K * min;
		
		System.out.println(X1 + " " + Y1 + " " + Z1);
		

	}

}
