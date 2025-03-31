package class3;

import java.io.*;
import java.util.*;

public class Boj_7576_토마토 {

    static int N, M, yet = 0;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        Queue<int[]> que = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) {
                    yet++;
                } else if(map[i][j] == 1){
                    que.offer(new int[] {i, j});
                }
            }
        }

        int days = 0;

        if(yet == 0) {
            System.out.println(0);
            return;
        }

        while(!que.isEmpty() && yet > 0) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                int[] cur = que.poll();
                int r = cur[0];
                int c = cur[1];
                for(int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                        map[nr][nc] = 1;
                        yet--;
                        que.offer(new int[] {nr, nc});
                    }
                }
            }

            days++;
        }

        if(yet > 0) {
            System.out.println(-1);
        } else {
            System.out.println(days);
        }
    }

}