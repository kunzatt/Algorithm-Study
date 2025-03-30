package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2577 {
	
	static int A, B, C, len;
	static String mul;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		mul = String.valueOf(A * B * C);
		char[] c = mul.toCharArray();
		len = c.length;
		nums = new int[10];
		for(int i = 0; i < len; i++) {
			nums[c[i] - '0']++;
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(nums[i]);
		}

	}

}
