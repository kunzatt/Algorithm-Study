import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1989 {
	static int T;
	static char[] arr = new char[10];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			arr = br.readLine().toCharArray();
			
			int num = palindrome(arr.length, arr);
			
			System.out.println("#" + t + " " + num);
		}
	}
	
	// 회문 확인!
	public static int palindrome(int n, char[] arr) {
		for(int i = 0; i < n / 2; i++) {
			if(arr[i] != arr[n-i-1]) {
				return 0;
			}
		}
		
		return 1;
	}
}
