import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M, X;
    static final int INF = Integer.MAX_VALUE;
    static class Road implements Comparable<Road> {
        int town; // 도착마을
        int time; // 소요시간

        public Road(int town, int time) {
            this.town = town;
            this.time = time;
        }

        @Override
        public int compareTo(Road road) {
            return this.time - road.time;
        }
    }
    
    static ArrayList<ArrayList<Road>> roads;
    static ArrayList<ArrayList<Road>> reverseRoads;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        roads = new ArrayList<>();
        reverseRoads = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            roads.add(new ArrayList<>());
            reverseRoads.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            roads.get(start).add(new Road(end, time));
            reverseRoads.get(end).add(new Road(start, time));
        }

        // X에서 각 마을로 가는 최단 시간
        int[] fromX = dijkstra(X, roads);

        // 각 마을에서 X로 가는 최단 시간
        int[] toX = dijkstra(X, reverseRoads);

        // 가장 오래 걸리는 학생
        int maxTime = 0;
        for(int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, fromX[i] + toX[i]);
        }

        System.out.println(maxTime);
    }

    static int[] dijkstra(int start, ArrayList<ArrayList<Road>> graph) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(start, 0));

        while(!pq.isEmpty()) {
            Road road = pq.poll();

            int currentTown = road.town;
            int currentTime = road.time;

            if(dist[currentTown] < currentTime) continue;

            for(Road next : graph.get(currentTown)) {
                int nextTown = next.town;
                int nextTime = currentTime + next.time;

                if(nextTime < dist[nextTown]) {
                    dist[nextTown] = nextTime;
                    pq.offer(new Road(nextTown, nextTime));
                }
            }
        }

        return dist;
    }
}
