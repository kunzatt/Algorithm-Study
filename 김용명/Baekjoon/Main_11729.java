import java.io.*;

public class Main_11729 {
	
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb.append((int) Math.pow(2, N) - 1).append("\n");
		
		sol(N, 1, 2, 3);
		System.out.println(sb);

	}
	
	// N-1개를 a에서 b까지 옮기가 크기가 N인 판을 c로 옮긴 후 b에서 c로 N-1개를 옮기면 된다.
	// 재귀를 활용해 N-1이 이동하는 위치의 시작과 끝을 잘 설정해준다.
	static void sol(int N, int a, int b, int c) {
		
		if (N == 1) {
			sb.append(a + " " + c).append("\n");
			return;
		}
		
		sol(N-1, a, c, b);

		sb.append(a + " " + c).append("\n");
		
		sol(N-1, b, a, c);
		
	}

}
