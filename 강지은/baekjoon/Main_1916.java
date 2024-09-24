import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {
	
	static int N, M;
	static int[][] weight;
	static int[] distance;
	static int max = 100000000; // 최대 노드 * 최대 간선
	static int s, e;
	
	static class Node implements Comparable<Node>{
		int idx;
		int distance;
		
		public Node(int idx, int distance) {
			this.idx = idx;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		weight = new int[N][N];
		distance = new int[N];
		
		for (int r = 0; r < N; r++) {
			distance[r] = max;
			for (int c = 0; c < N; c++) {
				weight[r][c] = max;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sn = Integer.parseInt(st.nextToken())-1;
			int en = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			
			if (weight[sn][en] < cost) continue;
			weight[sn][en] = cost;
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken())-1;
		e = Integer.parseInt(st.nextToken())-1;
		
		dijkstra(s);
		
		System.out.println(distance[e]);
		
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int current = node.idx;
			int cost = node.distance;
			
			if (cost > distance[current])
				continue;
			
			for (int i = 0; i < N; i++) {
				if (distance[i] > weight[current][i]+distance[current]) {
					distance[i] = weight[current][i]+distance[current];
					pq.offer(new Node(i, distance[i]));
				}
			}
			
		}
		
	}
	
}
