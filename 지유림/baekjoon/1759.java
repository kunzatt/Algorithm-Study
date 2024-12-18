import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759_암호만들기 {
	static int N, C;
	static char[] ch;
	static char[] password;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ch = new char[C];
		password = new char[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			ch[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(ch);
		
		dfs(0, 0, 0, 0);
		
		System.out.println(sb);
	}
	
	// 개수, 시작위치, 모음개수, 자음개수
	static void dfs(int cnt, int start, int 모음, int 자음) {
		if(cnt == N) {
			if(모음 >= 1 && 자음 >= 2) {
				// 최소 모음 한개, 자음 두개 이상
				
				for(int i = 0; i < N; i++) {
					sb.append(password[i]);
				}
				
				sb.append("\n");
			}
			
			return;
		}
		
		for(int i = start; i < C; i++) {
			password[cnt] = ch[i];
			
			// 모음이면..
			if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
				dfs(cnt+1, i+1, 모음+1, 자음);
			} else { // 모음 아니면 자음이다요
				dfs(cnt+1, i+1, 모음, 자음+1);
			}
		}
	}
}
