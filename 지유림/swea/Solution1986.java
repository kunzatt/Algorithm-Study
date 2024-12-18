import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int N, T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int sum = 0;
			
			for(int i = 1; i <= N; i++) {
				int num = i;
				if(num % 2 == 0) {
					num *= -1;
				}
				
				sum += num;
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}
