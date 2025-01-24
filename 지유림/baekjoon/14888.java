import java.io.*;
import java.util.*;

public class Main14888_연산자끼워넣기 {
	// -10억 ~ 10억 => int가능
	static int N;
	static int[] result;
	static int[] oper;
	static int max, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = new int[N];
		oper = new int[4];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		dfs(result[0], 1);

		System.out.println(max);
		System.out.println(min);
		
	}

	static void dfs(int num, int cnt) {
		if(cnt == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for(int i = 0; i < 4; i++) {
			if(oper[i] >= 1) {
				oper[i]--; // 해당 연산자 감소함

				if(i == 0) {	// +
					dfs(num + result[cnt], cnt+1);
				} else if(i == 1) { // -
					dfs(num - result[cnt], cnt+1);
				} else if(i == 2) { // *
					dfs(num * result[cnt], cnt+1);
				} else if(i == 3) { // /
					dfs(num / result[cnt], cnt+1);
				}

				oper[i]++;
			}

		}
	}
}
