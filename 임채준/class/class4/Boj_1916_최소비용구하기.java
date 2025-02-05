package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1916_최소비용구하기 {

    static class Node implements Comparable<Node>{
    // 시작점에 대한 끝점과 비용을 저장하기 위한 클래스
    // Comparable 인터페이스에 제네릭 타입으로 지정해 줌으로써 Node 객체 간 대소비교 가능
        int end;
        int weight;
        // 필드, 멤버 변수
        // 필드: 클래스에 선언된 변수 통칭
        // 멤버 변수: 클래스의 멤버로 선언된 변수
        // 인스턴스 변수: static이 아닌 필드를 특별히 지칭할 때

        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
        // 생성자(이 객체의 end와 weight는 각 매개변수로 들어온 값들)

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
        // comparable 인터페이스의 compareTo 메서드 오버라이드
        // 빼서 양수면 내가 더 큼, 0이면 같음, 음수면 내가 더 작음
    }

    static ArrayList<ArrayList<Node>> graph;
    static int[] cost;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;
    static int N, M, start, end, weight, depart, arrive;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 도시 개수
        M = Integer.parseInt(br.readLine());
        // 버스 노선 개수

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        // ArrayList: 동적으로 크기가 변함, 제네릭을 사용해서 어떤 타입이든 저장 가능
        // 바깥 ArrayList에는 시작점 저장
        // 안쪽 ArrayList에는 각 시작점에 대한 끝점과 비용을 Node객체로 저장할 예정

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            // 버스 노선 시작점
            end = Integer.parseInt(st.nextToken());
            // 버스 노선 끝점
            weight = Integer.parseInt(st.nextToken());
            // 해당 버스 노선 비용
            graph.get(start).add(new Node(end, weight));
            // 시작점에 대한 끝점과 비용을 Node로 저장
            // get() 메서드는 ArrayList의 index를 통해 해당 인덱싀의 요소를 가져옴
            // add() 메서드로 입력값이 들어오는 순서대로 안쪽 ArrayList에 Node들이 쌓임
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        depart = Integer.parseInt(st.nextToken());
        // 출발점
        arrive = Integer.parseInt(st.nextToken());
        // 도착점

        cost = new int[N + 1];
        // 비용 저장 배열 생성
        visited = new boolean[N + 1];
        // 방문 저장 배열 생성
        Arrays.fill(cost, INF);
        // 비용 배열에 INF 값 채워놓기

        System.out.println(dijkstra(depart, arrive));

    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        cost[start] = 0;
        // 시작점의 비용은 0으로 시작
        pq.offer(new Node(start, 0));
        // 프라이어리티 큐에 들어온 현재 시작점을 끝점으로 비용과 함께 넣기

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            // 들어온 현재 노드에 대해
            if(visited[cur.end]) continue;
            visited[cur.end] = true;
            // 방문 기록

            for(Node next: graph.get(cur.end)){
            // 현재 노드에 들어온 끝점을 시작점으로 하여 ArrayList에 있는 모든 node들에 대해
                if(!visited[next.end] && cost[next.end] > cost[cur.end] + next.weight){
                // Node들 중 방문하지 않았었고, 해당 도시로 가는데 드는 저장된 비용이 현재 노드의 비용과 다음 노드의 비용의 합보다 크다면
                    cost[next.end] = cost[cur.end] + next.weight;
                    // 다음 노드로 가는 저장될 비용은 현재 노드의 비용과 다음 노드의 비용의 합
                    // 즉, 초기에는 INF에서 현노드비용+다음노드비용 이렇게 되겠죠?
                    pq.offer(new Node(next.end, cost[next.end]));
                    // 1번 도시에서 이어진 모든 도시로의 최소비용 설정, 이어진 모든 도시들은 프라이어리티 큐로 들어가서
                    // 큐가 빌때까지 이 과정을 진행(visited를 통해 뒤로 가는 행동을 방지)
                }
            }
        }
        return cost[end];
        // 도착 도시로 가는데 드는 최소 비용 반환
    }


}
