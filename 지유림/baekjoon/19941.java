import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static char[] chars;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 식탁의 길이
		K = Integer.parseInt(st.nextToken());	// 범위
		
		chars = new char[N];
		chars = br.readLine().toCharArray();
		int cnt = 0;
		

		// i - K ~ i + K 까지
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == 'P') {
				for(int j = i - K; j <= i + K; j++) {
					if(j >= 0 && j < chars.length && chars[j] == 'H') {
						chars[j] = 'X';
						cnt++;
						break;
					}
				}
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
