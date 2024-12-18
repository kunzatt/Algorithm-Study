package boj;

import java.util.Scanner;

public class Main_10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		int max = -1000000;
		int min = 1000000;
		
		
		for(int i = 0; i<N; i++) {
			nums[i] = sc.nextInt();
			if(nums[i] < min) {
				min = nums[i];
			}
			if(nums[i] > max) {
				max = nums[i];
			}
		}
		System.out.println(min + " " + max);
		sc.close();
	}
}
