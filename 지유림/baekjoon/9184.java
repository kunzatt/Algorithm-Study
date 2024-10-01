import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  습관처럼 while문 안에 new int[21][21][21] 쓰면 메모리초과.. 
  어차피 계속 같은거 돌리니까 한번 해놓으면 계속 써도 됨
  메모이제이션 하기 어렵다....
*/

public class Main9184_신나는함수실행 {
	static int[][][] abc = new int[21][21][21]; // 매번 초기화 할 필요없음
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1) {
				break;
			} 
			

			sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a, b, c)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int w(int a, int b, int c) {
		// 메모이제이션
		if(check(a, b, c) && abc[a][b][c] != 0) return abc[a][b][c];
		
		
		if(a <= 0 || b <= 0 || c <= 0) return 1;
		
		if(a > 20 || b > 20 || c > 20) 
			return abc[20][20][20] = w(20, 20, 20);
		
		if(a < b && b < c) {
			return abc[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);

		}
		
		return abc[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
	
	static boolean check(int a, int b, int c) {
		return a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20;
	}
	
}
