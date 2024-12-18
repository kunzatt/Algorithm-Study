package java0804;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1074 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int num = 0;
		
		while(N!=0) {
			N -= 1;
			
			//1사분면
			if(r < Math.pow(2, N) && c < Math.pow(2, N)) {
				num += Math.pow(2, N) * Math.pow(2, N)*0;
			}
			// 2사분면
			else if(r < Math.pow(2, N) && c >= Math.pow(2, N)) {
				num += Math.pow(2, N) * Math.pow(2, N) * 1;
				c-= Math.pow(2, N);
			}
			// 3사분면
			else if(r >= Math.pow(2, N) && c < Math.pow(2, N)) {
				num += Math.pow(2, N) * Math.pow(2, N) * 2;
				r -= Math.pow(2, N);
			}
			// 4사분면
			else {
				num += Math.pow(2, N) * Math.pow(2, N) * 3;
				r -= Math.pow(2, N);
				c -= Math.pow(2, N);
			}
		}
		System.out.println(num);
		
	}
		
	
}
