import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1107_리모컨 {
	static int N, M;	// 이동하려고 하는 채널 N, 고장난 채널 개수 M
	static boolean[] visited;
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		visited = new boolean[10];
		min = Math.abs(N - 100);	// 현재 채널이 100이니ㅣ까

		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				int num = Integer.parseInt(st.nextToken());
				visited[num] = true;
			}
		}
		


		for(int i = 0; i <= 999999; i++) {
			String num = String.valueOf(i);

			boolean flag = false;
			for (int j = 0; j < num.length(); j++) {
				if (visited[num.charAt(j) - '0']) {
					flag = true;	// 고장난 버튼 이면 멈춰
					break;
				}
			}
			if (!flag) {
				//버튼을 누르는 횟수 중 가장 적은 횟수를 result에 담는다.
				int result = Math.abs(N - i) + num.length();
				min = Math.min(min, result);
			}
		}

		System.out.println(min);
			
	}
}
