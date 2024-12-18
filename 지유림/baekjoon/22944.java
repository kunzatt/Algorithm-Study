import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// H : 현재 체력
// D : 우산 내구도
// U : 우산 , S : 현재 위치, E : 안전지대
public class Main {
    static int N, K, H, D;
    static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;
    static int[][] visited;
    static class Point {
        int r, c, h, d, count;
        boolean um;

        // r, c : 좌표
        // h : 현재 체력
        // d : 우산 내구도
        // count : 이동 횟수
        // d: 우산 여부
        public Point(int r, int c, int h, int d, int count) {
            super();
            this.r = r;
            this.c = c;
            this.h = h;
            this.d = d;
            this.count = count;
        }


    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());	// 길이
        H = Integer.parseInt(st.nextToken());	// 체력
        D = Integer.parseInt(st.nextToken());	// 우산 내구도

        map = new char[N][N];
        visited = new int[N][N];

        int sr, sc;
        sr = sc = 0;

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S') {
                    sr = i;
                    sc = j;
                }
            }
        }

        int result = bfs(sr, sc);
        System.out.println(result);

    }

    static int bfs(int sr, int sc) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(sr, sc, H, 0, 0));
        visited[sr][sc] = H;	// 첨엔 우산없고 체력만땅

        int min = Integer.MAX_VALUE;
        while(!que.isEmpty()) {
            Point p = que.poll();

            if(map[p.r][p.c] == 'E') {
                return p.count;
            }

            for(int d = 0; d < 4; d++) {
                int nr = p.r+drc[d][0];
                int nc = p.c+drc[d][1];
                int nd = p.d;   // 우산 내구도
                int nh = p.h;   // 체력


                if(!check(nr, nc)) continue;
                if(map[nr][nc] == 'E') {
                    return p.count + 1;
                }
                if(map[nr][nc] == 'U') {    // 현재 위치가 우산
                    nd = D;    // 새로 리셋
                }

                if(nd > 0) {    // 우산 내구도 있으면..
                    nd--;
                } else {    // 없으면
                    nh--;
                }

                // 지금이 방문했을 때보다 체력+우산내구도 많다? 그럼 더 갈수있어
                if(visited[nr][nc] < nd+nh) {
                    visited[nr][nc] = nd+nh;
                    que.offer(new Point(nr, nc, nh, nd, p.count+1));
                }
            }
        }
        return -1;
    }


    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
