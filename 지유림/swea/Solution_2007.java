import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			char[] chars = br.readLine().toCharArray();
			
			int cnt = 0;	// 마디 개수 셀 변수
			
			for(int i = 1; i < chars.length; i++) {
				boolean flag = false;	// 마디 맞는지 확인하는 flag
				cnt = 0;
				if(chars[0] == chars[i]) {
					cnt++;
					for(int j = 1; j < i; j++) {
						if(chars[0+j] != chars[i+j]){
							break;
						} else {
							cnt++;
							flag = true;
						}
					}
					
				}
				
				if(flag) break;
			}
			
			System.out.println("#" + t + " " + cnt);
			
		}
	}
}
