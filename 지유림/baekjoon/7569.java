import java.util.*;
import java.io.*;

public class Main7569_토마토 {
    static int N, M, H;
    static int[][][] map;  // 3차원 배열로 수정
    static class Tomato {
        int h, r, c, day;  // 높이 좌표 추가
        public Tomato(int h, int r, int c, int day) {
            this.h = h;
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }
    static Queue<Tomato> que;
    // 6방향: 위, 아래, 앞, 뒤, 왼쪽, 오른쪽
    static int[][] dir = {{0,0,1}, {0,0,-1}, {0,1,0}, {0,-1,0}, {1,0,0}, {-1,0,0}};
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        que = new LinkedList<>();
        result = 0;

        for(int h = 0; h < H; h++) {
            for(int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < M; c++) {
                    map[h][r][c] = Integer.parseInt(st.nextToken());
                    if(map[h][r][c] == 1) {
                        que.offer(new Tomato(h, r, c, 0));
                    }
                }
            }
        }

        bfs();
        System.out.println(result);
    }

    static void bfs() {
        Tomato t = null;
        while(!que.isEmpty()) {
            t = que.poll();

            for(int d = 0; d < 6; d++) {
                int nh = t.h + dir[d][0];
                int nr = t.r + dir[d][1];
                int nc = t.c + dir[d][2];

                if(!check(nh, nr, nc) || map[nh][nr][nc] != 0) continue;

                map[nh][nr][nc] = 1;
                que.offer(new Tomato(nh, nr, nc, t.day + 1));
            }
        }

        // 모든 토마토가 익었는지 확인
        for(int h = 0; h < H; h++) {
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    if(map[h][r][c] == 0) {
                        result = -1;
                        return;
                    }
                }
            }
        }

        result = t != null ? t.day : 0;
    }

    static boolean check(int h, int r, int c) {
        return h >= 0 && h < H && r >= 0 && r < N && c >= 0 && c < M;
    }
}
