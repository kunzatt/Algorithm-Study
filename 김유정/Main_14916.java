package java0804;

import java.util.Scanner;

public class Main_14916 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int sum;
		int min=n;
		
		sum = 0;
		
		for(int i = 0; i <= n/5; i++) {
			for(int j = 0; j <= n/2; j++) {
				sum = 5 * i + 2 * j;	
//				System.out.println(sum);
				if(sum == n) {
					min = Math.min(min, i+j);
				}
			}
		}
		if(min == n) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
			
		
	}
}
