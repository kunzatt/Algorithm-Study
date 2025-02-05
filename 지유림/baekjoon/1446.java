import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int end, cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    static int N, D;
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dist = new int[10001];


        graph = new ArrayList<>();
        for(int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
        }

        // 각 지점에서 다음 지점까지 기본 거리 1
        for(int i = 0; i < D; i++) {
            graph.get(i).add(new Node(i+1, 1));
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            // 도착지점이 고속도로보다 크면 무시
            if(end > D) continue;

            // 지름길이 더 길면 무시
            if(end - start < length) continue;

            graph.get(start).add(new Node(end, length));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        dijkstra();
        System.out.println(dist[D]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(0, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.cost > dist[node.end]) continue;


            for (Node next : graph.get(node.end)) {
                int cost = dist[node.end] + next.cost;

                if (cost < dist[next.end]) {
                    dist[next.end] = cost;
                    pq.offer(new Node(next.end, cost));
                }
            }
        }
    }
}
