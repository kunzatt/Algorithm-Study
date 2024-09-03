import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14225 {
	
	static int S;
	static int[] num;
	static boolean[] visit;
	static boolean[] check; // 부분합 체크

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = Integer.parseInt(br.readLine());
		num = new int[S];
		visit = new boolean[S];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			max += num[i];
		}

    // 가장 작은 자연수를 찾기 위한 배열
		check = new boolean[max+1];
		perm(0, 0);
		
		for (int i = 0; i < max; i++) {
			if (!check[i]) {
				System.out.println(i);
				return;
			}
		}

    // check 배열이 모두 true라면 max+1의 값이 가장 작은 자연수
		System.out.println(max+1);

	}

	private static void perm(int cnt, int sum) {
		if (cnt == S) {
			check[sum] = true;
			return;
		}
		
		visit[cnt] = true;
		perm(cnt+1, sum+num[cnt]);
		visit[cnt] = false;
		perm(cnt+1, sum);
		
	}

}
