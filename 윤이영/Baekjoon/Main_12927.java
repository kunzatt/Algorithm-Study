// 이상한 점: 스위치를 모두 끌 수 없는 경우가 없음..!

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12927 {
	static char[] s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sen = br.readLine();
		s = new char[sen.length()+1];
		for(int i=0; i<sen.length(); i++) {
			s[i+1] = sen.charAt(i);
		}
		// 전구 검사
		int cnt = 0;
		for(int i=1; i<s.length; i++) {
			if(s[i] == 'N')	//스위치가 꺼져있다면 패스
				continue;
			else {	// 스위치가 켜져 있다면
				cnt++;	
				for(int d = i; d<s.length; d+=i) {	// i의 배수 스위치를 반전
					if(s[d] == 'Y') {
						s[d] = 'N';
					}
					else {
						s[d] = 'Y';
					}
				}
			}
			// 스위치가 모두 꺼졌는지 체크
			if(check(s, i))
				break;
		}
		System.out.println(cnt);
	}
	
	static boolean check(char[] s, int i) {	
		while(i<s.length) {
			if(s[i++] == 'Y')
				return false;
		}
		return true;	// 스위치가 모두 꺼져있는지 체크
	}
}
