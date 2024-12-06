import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10819 {
	
	static int N;
	static int[] arr, select;
	static boolean[] visit;
	static int max;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		select = new int[N];
		visit = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		perm(0);
		
		System.out.println(max);
		
	}

	private static void perm(int cnt) {
		if (cnt==N) {
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(select[i]-select[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			select[cnt] = arr[i];
			perm(cnt+1);
			visit[i] = false;
		}
		
	}
	
}
