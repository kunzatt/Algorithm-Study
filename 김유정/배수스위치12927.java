package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배수스위치12927 {
	static char[] sw;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sw = br.readLine().toCharArray();
		
		cnt = 0;
		// 배열의 길이만큼 반복
		for(int i = 0; i < sw.length; i++) {
			// 불이 켜져있다면
			if(sw[i] == 'Y') {
				// check 메서드로 이동하고 cnt를 하나 더해라
				check(sw, i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	static void check(char[] sw, int i) {
		for(int j = 1; (i+1)*j-1 < sw.length; j++) {
			if(sw[(i+1)*j-1] == 'Y') {
				sw[(i+1)*j-1] = 'N';
			}else {
				sw[(i+1)*j-1] = 'Y';
			}
		}
		
	}
}
