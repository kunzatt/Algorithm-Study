package boj;

import java.io.IOException;
import java.util.Scanner;

public class Main_10871 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		int X = sc.nextInt();
		
		for(int i = 0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		for(int i = 0; i<N; i++) {
			if(nums[i] < X) {
				System.out.print(nums[i] + " ");
			}
		}
		sc.close();
		
	}
}
