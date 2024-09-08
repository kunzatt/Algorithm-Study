import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961 {

	static int N;
	static int[][] taste;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		taste = new int[N][2];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}

		powerset(0, 1, 0, 0);
		System.out.println(min);

	}

	private static void powerset(int cnt, int mul, int sum, int select) {
		if (cnt == N) {
			if (select > 0)
				min = Math.min(min, Math.abs(sum-mul));
			return;
		}
		
		powerset(cnt+1, mul*taste[cnt][0], sum+taste[cnt][1], select+1);
		powerset(cnt+1, mul, sum, select);
	}

}
