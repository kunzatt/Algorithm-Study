import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//0: 빈 칸
//1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
//9: 아기 상어의 위치

// 초기 아기상어 크기: 2
// 1초마다 상하좌우로 이동
// 이동은 자기크기보다 작거나 같은 물고기칸이나 빈칸만 이동 가능
// 정렬 하지말고, 애초에 상 -> 좌 -> 우 -> 하 순서로 하면 정렬 순서가 보장될 것 같다.

// 16236. 아기 상어 / 골드3 / 2시간 16분
public class BOJ_16236 {
    public static class Pos implements Comparable<Pos> {
        int y, x, dist;

        public Pos(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.dist == o.dist) {
                if (this.y == o.y) {
                    return this.x - o.x;
                }
                return this.y - o.y;
            }
            return this.dist - o.dist;
        }
    }

    public static class Shark {
        int y, x, size, eat;

        public Shark(int y, int x, int size) {
            this.y = y;
            this.x = x;
            this.size = size;
            this.eat = 0;
        }
    }

    static final int[] dy = {-1, 0, 0, 1};
    static final int[] dx = {0, -1, 1, 0};
    static int[][] arr;
    static int n;
    static Shark s;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    arr[i][j] = 0;
                    s = new Shark(i, j, 2);
                }
            }
        }
        int time = 0;
        while (true) {
            Pos p = browse(s.y, s.x);
            if (p == null) {
                break;
            }
            move(p);
            time += p.dist;
        }
        System.out.println(time);

    }

    // 자기보다 작은 물고기만 먹을 수 있다. 그런 물고기를 찾는 함수
    // 주의할 점: 최소 거리인 물고기들 중에 가장 위, 가장 왼쪽에 있는 물고기를 먼저 대상으로 해야함
    // 상좌우하 로 탐색하게 설정해놓으면, 자연스럽게 먼저 발견한 놈은 가장 최적의 먹이가 됨.
    // 그래서 만약에 minDist가 같을 때 조건문으로 갱신해주면 된다.
    // 아니면 우선순위 큐로 그 세가지 조건에 따라 자동으로 값이 나오게 설정하면 되겠다.
    // 우선순위 큐로 먼저 나온 놈의 인덱스 값이 0이 아니고, 아기 상어의 사이즈 보다 작으면 바로 리턴하면 됨
    public static Pos browse(int y, int x) {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];
        pq.add(new Pos(y, x, 0));
        visited[y][x] = true;

        while (!pq.isEmpty()) {
            Pos p = pq.poll();
            if (arr[p.y][p.x] != 0 && arr[p.y][p.x] < s.size) {
                return p;
            }
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx] && arr[ny][nx] <= s.size) {
                    visited[ny][nx] = true;
                    pq.add(new Pos(ny, nx, p.dist + 1));
                }
            }
        }
        return null;
    }

    // 가장 가까운 물고기에게 가는 함수
    public static void move(Pos p) {
        arr[p.y][p.x] = 0;
        s.y = p.y;
        s.x = p.x;
        s.eat++;
        if (s.size == s.eat) {
            s.size++;
            s.eat = 0;
        }
    }
}
