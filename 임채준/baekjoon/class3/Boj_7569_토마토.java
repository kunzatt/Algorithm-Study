package class3;

import java.io.*;
import java.util.*;

public class Boj_7569_토마토 {

    static int N, M, H;
    static int[][][] map;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        Queue<int[]> que = new LinkedList<>();
        int yet = 0;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if (map[h][n][m] == 1) {
                        que.offer(new int[]{h, n, m});
                    } else if (map[h][n][m] == 0) {
                        yet++;
                    }
                }
            }
        }

        if (yet == 0) {
            System.out.println(0);
            return;
        }

        int time = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] cur = que.poll();

                for (int d = 0; d < 6; d++) {
                    int nh = cur[0] + dz[d];
                    int nx = cur[1] + dx[d];
                    int ny = cur[2] + dy[d];

                    if (check(nh, nx, ny)) {
                        map[nh][nx][ny] = 1;
                        que.offer(new int[]{nh, nx, ny});
                        yet--;
                    }
                }
            }

            time++;

            if (yet == 0) {
                System.out.println(time);
                return;
            }
        }

        System.out.println(-1);
    }

    public static boolean check(int h, int n, int m){
        return h >= 0 && h < H && n >= 0 && n < N && m >= 0 && m < M && map[h][n][m] == 0;
    }
}