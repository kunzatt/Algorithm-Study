import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1970_쉬운거스름돈 {
	static int T, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		for(int t =  1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			int num = N;
			
			int[] result = new int[money.length];
			
			for(int i = 0; i < money.length; i++) {
				int tmp = num % money[i];
				num /= money[i];
				
				if(num <= 0) {
					num = tmp;
				} else {
					result[i] = num;
					num = tmp;
				}
			}
			
			System.out.println("#" + t);
			for(int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
	}
}
