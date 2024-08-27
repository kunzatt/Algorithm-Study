import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] visited; // 방문여부
	static int[] result; // 결과 담을 
	static int[] p; // 
	
	// M = R
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		visited = new boolean[N];
		p = new int[N];
		
		for(int i = 1; i <= N; i++) {
			p[i-1] = i;
		}
		
		npr(0, 0);
		
	}

	static void npr(int idx, int cnt) {
		if(cnt == M) {
			for(int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			result[cnt] = p[i];
			
			npr(i+1, cnt+1);
			
			visited[i] = false;
			
		}
	}
}
