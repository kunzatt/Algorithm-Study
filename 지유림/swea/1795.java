import java.io.*;
import java.util.*;

public class Solution_인수의생일파티 {
    static int T, N, M, X;
    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] rgraph;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            rgraph = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
                rgraph[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph[a].add(new Node(b, weight));  // 정방향
                rgraph[b].add(new Node(a, weight));  // 역방향
            }

            int[] aTime = dijkstra(graph);
            int[] bTime = dijkstra(rgraph);

            int max = 0;
            for(int i = 1; i <= N; i++) {
                if(i != X && aTime[i] != Integer.MAX_VALUE && bTime[i] != Integer.MAX_VALUE) {
                    int total = aTime[i] + bTime[i];
                    max = Math.max(max, total);
                }
            }

            sb.append("#" + t + " " + max + "\n");
        }
        System.out.println(sb.toString());
    }

    static int[] dijkstra(ArrayList<Node>[] g) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N+1];
        visited = new boolean[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        pq.offer(new Node(X, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();

            if(visited[n.v]) continue;
            visited[n.v] = true;

            for(Node next : g[n.v]) {
                if(!visited[next.v] && dist[next.v] > dist[n.v] + next.w) {
                    dist[next.v] = dist[n.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }
}
