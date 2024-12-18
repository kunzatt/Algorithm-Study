package boj;

import java.util.Scanner;

public class Main_10813 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] balls = new int[N];
		for(int i = 0; i<N; i++) {
			balls[i] = i+1;
		}
		
		for(int i = 0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int tmp;
			tmp = balls[a-1];
			balls[a-1] = balls[b-1];
			balls[b-1] = tmp;
		}
		
		for(int i = 0; i<N; i++) {
			System.out.print(balls[i] + " ");
		}
		sc.close();
	}

}
