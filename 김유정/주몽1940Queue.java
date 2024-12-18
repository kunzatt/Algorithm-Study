package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주몽1940Queue {
	static int N,M;
	static int sum; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> nums = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		System.out.println(nums);
		
		boolean check = true;;
		sum = 0;	
		for(int i = 0; i <= nums.size(); i++) {
			int a = nums.poll();
			for(int j = 0; j < nums.size(); j++) {
				int b = nums.poll();
				System.out.printf("a : %d, b : %d\n", a, b);
				if(a + b == M) {
					check = false;
					sum++;
					break;
				}
				nums.add(b);
			}
			if(check) {
				nums.add(a);
			}
		}
		System.out.println(sum);
	}
}

/*
 * a : 2, b : 7
 * a : 4, b : 1
 * a : 4, b : 5
 * a : 3, b : 1
 * 
 */