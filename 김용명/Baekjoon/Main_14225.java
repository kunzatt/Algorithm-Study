import java.io.*;
import java.util.*;

public class Main_14225 {
	
	static int N;
	static int[] p, ans;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		ans = new int[2000000];
		powerSet(0, 0);
		for (int i = 1; i < 2000000; i++) {
			if (ans[i] == 0) {
				System.out.println(i);
				break;
			}
		}

	}

	static void powerSet(int cnt, int sum) {
		if (cnt == N) {
			ans[sum] = 1;
			return;
		}
		powerSet(cnt+1, sum + p[cnt]);
		powerSet(cnt+1, sum);
		
	}

}
