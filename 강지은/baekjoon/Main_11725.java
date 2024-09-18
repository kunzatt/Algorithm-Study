import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725 {

	static int N;
	static List<Integer>[] adj;
	static boolean[] visit;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		p = new int[N+1];
		
		adj = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			adj[i] = new ArrayList<>();
			adj[i].add(1);
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj[v].add(e);
			adj[e].add(v);
		}
		
		bfs(1);
		
		for (int i = 2; i < N+1; i++) {
			System.out.println(p[i]);
		}
		
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visit[v] = true;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int next : adj[cur]) {
				if (visit[next]) continue;
				queue.add(next);
				visit[next] = true;
				p[next] = cur;
			}
		
		}
	
	}

}
