import java.util.Scanner;

public class Main {
	static int[] arr = new int[26];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		for(int i = 0; i < s.length(); i ++) {	
			// 대문자 범위
			if('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
				arr[s.charAt(i) - 'A']++;
			} else { // 소문자 범위
				arr[s.charAt(i) - 'a']++;
			}
		}
		
		int max = -1;
		char ch = '?';
		
		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				ch = (char)(i + 'A');
			} else if(arr[i] == max) {
				ch = '?';
			}
		}
		
		System.out.println(ch);
	}
}
