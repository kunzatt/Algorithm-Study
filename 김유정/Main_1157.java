package algol0808;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] cnt = new int[26];
		int max=0;
		char aws='?';
		boolean check = true;
				
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >96) {
				cnt[s.charAt(i)-97]++;
			}else {
				cnt[s.charAt(i)-65]++;
			}
		}
		System.out.println(Arrays.toString(cnt));
		for(int i = 0; i < cnt.length; i++) {
			if(max == cnt[i] && max != 0) {
				aws = '?';
			}else if(max < cnt[i]) {
				max = cnt[i];
				aws = (char)(i + 65);
				check = true;
			}
		}
		
		System.out.println(aws);
		
	}
}
