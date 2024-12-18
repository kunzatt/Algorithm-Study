package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] map = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken()); 
		} // 입력
		
		// 구현
		int max = -10000000; // -100 * 100,000인 경우 (최악의 값)
		int sum;
		for(int i = 0; i < N-K+1; i++) {
			sum = 0;
			for(int j = 0; j < K; j++) { // 연속적인 수의 개수만큼 돌기
				sum += map[i+j];
			}
			max = Math.max(max, sum); // 최대인 값으로 받기
		}
		System.out.println(max); // 최대인값 출력
		
	}
}
