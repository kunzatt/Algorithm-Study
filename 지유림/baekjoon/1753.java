import java.io.*;
import java.util.*;

public class Main1753_최단경로 {
    static int V, E, K;
    static ArrayList<List<Node>> graph;
    static int[] dist;
    static class Node implements Comparable<Node> {
        int u, v, w;

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보
        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(u, v, w));
        }

        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(K);

        for(int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i] + "\n");
            }
        }
        System.out.print(sb);
    }

    static void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, k, 0));
        dist[k] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist[cur.v] < cur.w) continue;

            for(Node next : graph.get(cur.v)) {
                if(dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    pq.offer(new Node(next.u, next.v, dist[next.v]));
                }
            }
        }
    }
}
