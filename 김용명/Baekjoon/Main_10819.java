import java.io.*;
import java.util.*;

public class Main_10819 {
	
	static int N, max;
	static int[] arr, nums;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		max = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
		nums = new int[N];
		dfs(0);
		
		System.out.println(max);

	}

	private static void dfs(int cnt) {
		
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(nums[i] - nums[i+1]);
			}
			max = Math.max(sum, max);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			nums[cnt] = arr[i];
			dfs(cnt+1);
			visited[i] = false;
		}
		
	}

}
