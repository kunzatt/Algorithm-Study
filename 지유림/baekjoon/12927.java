import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[] chars;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 받은 것들을 char로 변환하기!
		chars = br.readLine().toCharArray();
		
		int cnt = 0;
		for(int i = 0; i < chars.length; i++) {
			// 배열 0부터 돌면서 꺼야하는 스위치를 찾기
			if(chars[i] == 'Y') {
				cnt++;	// 들어오게 되면 스위치를 누른거니까 cnt 올려주기
				
				// 배수를 찾아야 하니까, 배수만큼 증가하게 하기
				// i가 0부터 시작했으니까, i+1 한 것을 높여줘야함 
				for(int j = i; j < chars.length; j += (i+1)) {
					if(chars[j] == 'Y') chars[j] = 'N';
					else chars[j] = 'Y';
				}
			}
		}
		
		System.out.println(cnt);
	}
}
