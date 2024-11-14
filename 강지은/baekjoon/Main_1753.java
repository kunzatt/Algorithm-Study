import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {
	
	static int V, E, K;
	static List<List<Node>> weight;
	static int[] distance;
	static int max = 1000000;
	
	static class Node implements Comparable<Node> {
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
		
	}
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine())-1;
        
        weight = new ArrayList<>();
        for (int i = 0; i < V; i++) {
			weight.add(new ArrayList<>());
		}
        
        distance = new int[V];
        for (int i = 0; i < V; i++) {
        	distance[i] = max;
		}
        
        for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			weight.get(u).add(new Node(v, w));
		}
        
        dijkstra(K);
        
        for (int cost : distance) {
        	if (cost==max) System.out.println("INF"); 
        	else System.out.println(cost);
		}
        
    }

	private static void dijkstra(int k) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[k] = 0;
		pq.add(new Node(k, 0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int current = node.index;
			int cost = node.distance;
			
			if (cost > distance[current]) continue;
			
			for (int i = 0; i < weight.get(current).size(); i++) {
				Node next = weight.get(current).get(i);
				if (distance[next.index] > cost+next.distance) {
					distance[next.index] = cost+next.distance;
					pq.add(new Node(next.index, distance[next.index]));
				}
			}
			
		}
		
	}
    
}
