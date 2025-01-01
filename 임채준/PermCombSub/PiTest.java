package PermCombSub;

import java.util.Arrays;

public class PiTest {
	
	static int[] p = {1, 2, 3, 4, 5};
	static int N, R, count;
	static boolean[] visited;
	static int[] nums;

	public static void main(String[] args) {
		
		N = p.length;
		R = 3;
		count = 0;
		visited = new boolean[N];
		nums = new int[R];
		pi(0);
		System.out.println(count);

	}

	static void pi(int cnt) {
		if(cnt == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			nums[cnt] = p[i];
			pi(cnt + 1);
			nums[cnt] = 0;
			visited[i] = false;
		}
		
	}

}
