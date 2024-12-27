import java.io.*;
import java.util.*;

public class Main1916_최소비용구하기 {
    static int N, M;
    static class City implements Comparable<City> {
        int end, weight;

        public City(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(City c) {
            return this.weight - c.weight;
        }
    }
    static List<ArrayList<City>> node;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        node = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < N+1; i++) {
            node.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            node.get(start).add(new City(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(a, b));
    }

    // 다익스트라
    public static int dijkstra(int start, int end) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            City n = pq.poll();
            int de = n.end;

            if(visited[de]) continue;
            visited[de] = true;

            for (City city : node.get(de)) {
                if (!visited[city.end] && dist[city.end] > dist[de] + city.weight) {
                    dist[city.end] = dist[de] + city.weight;
                    pq.add(new City(city.end, dist[city.end]));
                }
            }
        }
        return dist[end];
    }
}
