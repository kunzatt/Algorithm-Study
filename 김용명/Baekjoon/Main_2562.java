package boj;

import java.util.Scanner;

public class Main_2562 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[9];
		int max=Integer.MIN_VALUE;
		int idx=0; 
		
		for(int i = 0; i<9; i++) {
			nums[i] = sc.nextInt();
		}
		for(int i = 0; i<9; i++) {
			if(nums[i] > max) {
				max = nums[i];
				idx = i+1;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	
		sc.close();
	}
	

}
