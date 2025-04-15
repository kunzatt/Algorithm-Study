package class4;

import java.io.*;
import java.util.*;

public class Boj_1504_특정한최단경로 {

    static int N, E;
    static ArrayList<ArrayList<Node>> graph;
    static final int INF = 200000000;

    static class Node implements Comparable<Node> {

        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long path1 = 0;
        path1 += dijkstra(1, v1);
        path1 += dijkstra(v1, v2);
        path1 += dijkstra(v2, N);

        long path2 = 0;
        path2 += dijkstra(1, v2);
        path2 += dijkstra(v2, v1);
        path2 += dijkstra(v1, N);

        long result = Math.min(path1, path2);
        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static int dijkstra(int start, int end) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curNode = cur.end;
            int curWeight = cur.weight;

            if (distance[curNode] < curWeight) continue;

            for (Node next : graph.get(curNode)) {
                int nextNode = next.end;
                int nextWeight = curWeight + next.weight;

                if (nextWeight < distance[nextNode]) {
                    distance[nextNode] = nextWeight;
                    pq.offer(new Node(nextNode, nextWeight));
                }
            }
        }

        return distance[end];
    }
}