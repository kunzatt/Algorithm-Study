import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2503 {

	static int N;
	static String[] num;
	static int[] s, b;
	static int cnt;
	
	static int[] result = new int[3];
	static int[] p = {1,2,3,4,5,6,7,8,9};
	static boolean[] visit = new boolean[9];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// N개의 게임 결과 담기
		num = new String[N];
		s = new int[N];
		b = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i] = st.nextToken();
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			
		}
		
		cnt = 0;
		check(0);
		System.out.println(cnt);
	}

	private static void check(int depth) {
		if (depth == 3) {
			// N개의 게임 결과 비교
			for (int i = 0; i < N; i++) {
				int scnt = 0;
				int bcnt = 0;
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (num[i].charAt(j)-'0' == result[k]) {
							// 스트라이크 카운트
							if (j == k) {
								scnt++;
								break;
							} else // 볼 카운트
								bcnt++;
						}
					}
				}
				
				// 카운트가 다르면 다음 숫자로 넘어감
				if (scnt != s[i] || bcnt != b[i])
					return;
			}
			
			// 카운트가 똑같으면 가능성 있는 답 카운트
			cnt++;
			return;
		}
		
		for (int i = 0; i < p.length; i++) {
			if (visit[i]) continue;
			result[depth] = p[i];
			visit[i] = true;
			check(depth+1);
			visit[i] = false;
		}
		
	}

}
