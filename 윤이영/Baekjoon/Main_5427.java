import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int tc, w, h, ans;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> ppl;
    static Queue<int[]> fire;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            w = sc.nextInt();
            h = sc.nextInt();
            map = new char[h][w];
            visited = new boolean[h][w];
            ppl = new LinkedList<>();   // 초기화 추가
            fire = new LinkedList<>();  // 초기화 추가
            ans = -1;

            for (int i = 0; i < h; i++) {
                String S = sc.next();
                for (int j = 0; j < w; j++) {
                    map[i][j] = S.charAt(j);
                    if (map[i][j] == '@') {
                        ppl.add(new int[]{i, j, 0});
                        visited[i][j] = true; // 상근이 위치 방문 처리
                    } else if (map[i][j] == '*') {
                        fire.add(new int[]{i, j});
                    }
                }
            } // 입력 끝

            ans = bfs();

            if (ans < 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(ans);
            }
        }
    }

    private static int bfs() {
        while (!ppl.isEmpty()) {
            fire(); // 불 먼저 확산
            int size = ppl.size();
            for (int i = 0; i < size; i++) {
                int[] cur = ppl.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];
                    int time = cur[2];

                    if (!check(nr, nc)) {
                        return time + 1; // 범위 밖으로 나가면 탈출
                    }

                    if (!visited[nr][nc] && map[nr][nc] == '.') {
                        ppl.add(new int[]{nr, nc, time + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return -1; // 탈출 실패
    }

    private static void fire() {
        int size = fire.size();
        for (int i = 0; i < size; i++) {
            int[] cur = fire.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (!check(nr, nc)) continue;
                if (map[nr][nc] == '.' || map[nr][nc] == '@') {
                    map[nr][nc] = '*';
                    fire.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < h && c >= 0 && c < w;
    }
}
