import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[9];
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 0;
		int cnt = 0;
		for(int i = 0; i < nums.length; i++) {
			if(max < nums[i]) {
				max = nums[i];
				cnt = i + 1;
			}
		}
		
		System.out.println(max);
		System.out.println(cnt);
		
	}
}
