import java.io.*;
import java.util.*;

public class Main_1600 {

    static int K, W, H, ans;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] hdr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hdc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;

        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0, 0, K);
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);


    }

    static void bfs(int r, int c, int count, int k) {

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {r, c, 0, k});
        visited[r][c][k] = true;

        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int tr = temp[0];
            int tc = temp[1];
            int tcount = temp[2];
            int tk = temp[3];

            if (tr == H - 1 && tc == W - 1) ans = Math.min(tcount, ans);

            for (int i = 0; i < 4; i++) {
                int nr = tr + dr[i];
                int nc = tc + dc[i];

                if (!check(nr, nc) || visited[nr][nc][tk] || map[nr][nc] != 0) continue;
                visited[nr][nc][tk] = true;
                que.add(new int[] {nr, nc, tcount + 1, tk});
            }

            if (tk > 0) {

                for (int d = 0; d < 8; d++) {
                    int nr = tr + hdr[d];
                    int nc = tc + hdc[d];

                    if (!check(nr, nc) || visited[nr][nc][tk - 1] || map[nr][nc] != 0) continue;
                    visited[nr][nc][tk - 1] = true;
                    que.add(new int[] {nr, nc, tcount + 1, tk - 1});
                }

            }

        }

    }

    static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < H && c < W;
    }

}