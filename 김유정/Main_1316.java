package algol0808;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] check = new int[26];
//		System.out.println(Arrays.toString(check));
		int cnt = N;
		
		for(int n = 0; n < N; n++) {
			// 입력
			String ss = sc.next();
			System.out.println(ss);
			
			Arrays.fill(check, 0);
			// 단어 길이만큼 반복
			check[ss.charAt(0)-97]++;
			for(int s = 1; s < ss.length(); s++) {
				if(ss.charAt(s-1) == ss.charAt(s)) {
					check[ss.charAt(s)-97]++;
					continue;
				}else if(check[ss.charAt(s)-97] > 0) {
					check[ss.charAt(s)-97] = -1000;
				}else if(check[ss.charAt(s)-97] == 0) {
					check[ss.charAt(s)-97]++;					
				}
			}
			
			for(int i = 0; i < check.length; i++) {
				if(check[i] < 0) {
					cnt --;
					break;
				}
			}
		}
		System.out.println(cnt);
		

	}
}
