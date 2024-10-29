import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1041 {

	static long N;
	static int[] dice;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dice = new int[6];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		long ans = 0;
		
		if (N == 1) {
			int max = 0;
			for (int i = 0; i < 6; i++) {
				ans += dice[i];
				max = Math.max(max, dice[i]);
			}
			System.out.println(ans-max);
			return;
		}
		
		// 3면 구하기
		int min3 = 0;
		for (int i = 0; i < 3; i++) {
			min3 += Math.min(dice[i], dice[5-i]);
		}
		
		// 2면 구하기
		int min2 = 100;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (j==i || j==5-i) continue;
				min2 = Math.min(min2, dice[i]+dice[j]);
			}
		}
		
		// 1면 구하기
		int min1 = 50;
		for (int i = 0; i < 6; i++) {
			min1 = Math.min(min1, dice[i]);
		}
		
		ans = min3*4 + min2*(2*N-3)*4 + min1*(5*N-6)*(N-2);

		System.out.println(ans);
	}

}
