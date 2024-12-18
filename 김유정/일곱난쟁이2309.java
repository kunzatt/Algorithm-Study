package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이2309 {
	static int[] height;
	static int find1, find2, sum;
	static boolean check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 9;
		height = new int[N];
		sum = 0;
		for(int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
//		System.out.println(sum);
		for(int i = 0; i < N-1; i++) {
			for(int j = i+1; j < N; j++) {
				int tmp = sum;
				tmp -= height[i] + height[j];
				if(tmp == 100) {
					find1 = height[i];
					find2 = height[j];
					check = true;
					break;
				}
			}
			if(check) break;
		}
		Arrays.sort(height);
		for(int i = 0; i < N; i++) {
			if(height[i] == find1 || height[i] == find2) {
				continue;
			}
			System.out.println(height[i]);
		}
	}
}
