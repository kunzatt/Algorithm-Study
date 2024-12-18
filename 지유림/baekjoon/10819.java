import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[] p;
	static boolean[] visited;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		p = new int[N];
		visited = new boolean[N];
		max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		perm(0);
		System.out.println(max);
	}
	
	
	static void perm(int cnt) {
		if(cnt == N) {
			int num = sum(p);
			
			max = Math.max(num, max);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			p[cnt] = arr[i];
			perm(cnt+1);
			visited[i] = false;
		}
	}
	
	static int sum(int[] arr) {
		int sum = 0;
		for(int i = 1; i < arr.length; i++) {
			sum += Math.abs(arr[i-1] - arr[i]);
		}
		
		return sum;
	}
}
