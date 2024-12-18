package com.ssafy.hw.step4;

import java.util.Scanner;

public class ProductValue {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] price = new int[N];
		int rank = 1;
		
		for(int i =0; i<N; i++) {
			int x = sc.nextInt();
			price[i] = x;
		}
		for (int i=0; i<N; i++) {
			rank = 1;
			for(int j = 0; j < N; j++) {
				if (price[i] < price[j]) {
					rank++;
				}
			}
			System.out.printf("%d ", rank);
		}
		System.out.println();
		
	}

}
