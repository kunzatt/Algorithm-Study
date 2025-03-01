import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1446 { 

	static int MAX = 10001;
    static int N, D;
    static ArrayList<Node>[] adj;
    static int[] distance;
    static class Node implements Comparable<Node> {
    	int d;
    	int cost;
		public Node(int d, int cost) {
			this.d = d;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[D+1];
        for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
        
        distance = new int[D+1];
        for (int i = 0; i < distance.length; i++) {
			distance[i] = MAX;
		}
        
        for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cut = Integer.parseInt(st.nextToken());
			if (start >= D) continue;
			if (cut >= end-start) continue;
			adj[start].add(new Node(end, cut));
		}
        
        dijkstra();
        
        System.out.println(distance[D]);
    }

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.cost > distance[cur.d]) continue;
			if (cur.d+1 > D) continue;
			
			if (cur.cost+1 <= distance[cur.d+1]) {
				distance[cur.d+1] = cur.cost+1;
				pq.add(new Node(cur.d+1, distance[cur.d+1]));
			}
			
			for (int i = 0; i < adj[cur.d].size(); i++) {
				Node next = adj[cur.d].get(i);
				
				if (next.d > D) continue;
				
				if (cur.cost+next.cost <= distance[next.d]) {
					distance[next.d] = cur.cost+next.cost;
					pq.add(new Node(next.d, distance[next.d]));
				}
				
			}
		}
		
	}
    
}
