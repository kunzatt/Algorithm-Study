import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;	// 갔다왔니? 하고 확인하는 배열
	static int[] p;
	static int[] result; // 결과값
	static int N, M;
	
	// nPr
	// M = R
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		p = new int[N];
		result = new int[M];
		for(int i = 1; i <= N; i++) {
			p[i-1] = i;
		}
		
		npr(0);
	}

	static void npr(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			result[cnt] = p[i];
			
			npr(cnt+1);
			
			result[cnt] = 0;
			visited[i] = false;
			
		}
		
	}
}
