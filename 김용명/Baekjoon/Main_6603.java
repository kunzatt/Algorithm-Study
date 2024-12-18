import java.io.*;
import java.util.*;

public class Main_6603 {
	
	static int N;
	static int[] nums;
	static int[] p;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0) break;
			p = new int[N];
			nums = new int[6];
			
			for (int i = 0; i < N; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			System.out.println();
		}

	}

	static void dfs(int cnt, int idx) {
		
		StringBuilder sb = new StringBuilder();
		if (cnt == 6) {
			for (int i : nums) {
				sb.append(i).append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		for (int i = idx; i < N; i++) {
			nums[cnt] = p[i];
			dfs(cnt+1, i+1);
		}
		
	}

}
