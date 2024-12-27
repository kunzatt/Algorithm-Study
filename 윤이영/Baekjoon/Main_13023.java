import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13023 {
	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static boolean result = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		visited = new boolean[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=0; i<N; i++) {
			visited[i] = true;	// 현재 노드 방문 처리
			dfs(i, 0);
			visited[i] = false;	// 백트래킹
			if(result) break;
		}
		
		System.out.println(result ? 1 : 0);
	}

	private static void dfs(int s, int depth) {
		if(depth == 4) {
			result = true;
			return;
		}
		
		for(int next: list[s]) {
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, depth+1);
				visited[next] = false;	// 백트래킹
				if(result) return;	// 이미 정답이 나왔다면 바로 리턴하여 종료
			}
		}
	}
}
