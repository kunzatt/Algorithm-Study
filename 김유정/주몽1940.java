package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주몽1940 {
	static int N,M;
	static int[] nums;
	static int sum; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		} // 입력
		
		sum = 0;	
		// 돌아라
		for(int i = 0; i < nums.length-1; i++) {
			int a = nums[i];
			for(int j = i+1; j < nums.length; j++) {
				int b = nums[j];
				// a+b = M이면 sum을 하나 올리고 정지
				if(a + b == M) {
					sum++;
					break;
				}
			}
		}
		System.out.println(sum);
	}
}
