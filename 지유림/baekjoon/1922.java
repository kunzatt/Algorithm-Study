
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1922_네트워크연결3 {
	static int N, M;
	static class Edge implements Comparable<Edge> {
		int V, E, W;

		public Edge(int v, int e, int w) {
			super();
			V = v;
			E = e;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [V=" + V + ", E=" + E + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Edge ed) {
			
			return Integer.compare(this.W, ed.W);
		}
	}
	
	static List<Edge>[] list;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		visited = new boolean[N];
		result = 0;
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
		
			list[v].add(new Edge(v, e, w));
			list[e].add(new Edge(e, v, w));
		}
		
		prim();
		System.out.println(result);
		
	}
	
	static void prim() {
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited[0] = true;
		
		int pick = 1;
		pq.addAll(list[0]);
		
		// N만큼 뽑으면 멈춰
		while(pick != N) {
			Edge ed = pq.poll();
			if(visited[ed.E]) continue; // 뽑은 친구면
			
			result += ed.W; // 비용추가
			visited[ed.E] = true;
			pick++;
			
			pq.addAll(list[ed.E]);
		}
	}
}
