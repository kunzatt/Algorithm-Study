package PermCombSub;

import java.util.Arrays;

public class DuComb {
	
	static int[] p = {1, 2, 3, 4, 5};
	static int N, R, count;
	static int[] nums;

	public static void main(String[] args) {
		
		N = p.length;
		R = 3;
		count = 0;
		nums = new int[R];
		comb(0, 0);
		System.out.println(count);

	}

	static void comb(int cnt, int start) {
		if(cnt == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for(int i = start; i < N; i++) {
			nums[cnt] = p[i];
			comb(cnt + 1, i);
			nums[cnt] = 0;
		}
		
	}

}
