package noclass;

import java.io.*;
import java.util.*;

public class Boj_10211_MaximumSubarray {
	
	static int T, N, X, max;
	static int[] arr, dp;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			dp = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dp[0] = arr[0];
			max = dp[0];
			for(int i = 1; i < N; i++) {
				dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
				max = Math.max(max, dp[i]);
			}
			System.out.println(max);
			
		}
		

	}

}
