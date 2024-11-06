import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1922 {
	static int N, M;
	static List<Edge>[] adjlist;
	static int ans;
	static boolean[] visited;
    
	static class Edge implements Comparable<Edge> {
		int a,b,c;
		public Edge(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adjlist = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			adjlist[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			adjlist[a].add(new Edge(a, b, c));
			adjlist[b].add(new Edge(b, a, c));
			
		}
		prim();
		System.out.println(ans);
		
	}

	private static void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		ans = 0;
		int pick = 1;
		pq.addAll(adjlist[0]);
		visited[0] = true;
		while(pick != N) {
			Edge e = pq.poll();
			if(visited[e.b]) continue;
			
			ans += e.c;
			visited[e.b] = true;
			pick++;
			pq.addAll(adjlist[e.b]);
		}
	}
}
