package boj;

import java.util.Scanner;

public class Main_10807 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] score = new int[N];
		for(int i = 0; i<N; i++) {
			score[i] = sc.nextInt();
		}
		int v = sc.nextInt();
		int cnt=0;
		
		for(int i = 0; i<N; i++) {
			if (score[i] == v) {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
