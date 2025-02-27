package class3;

import java.io.*;
import java.util.*;

public class Boj_21736_헌내기는친구가필요해 {

    static int N, M, sr, sc, ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> que = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            char[] c = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = c[j];
                if(map[i][j] == 'I'){
                    sr = i;
                    sc = j;
                }
            }
        }
        ans = 0;
        que.offer(new int[] {sr, sc});
        bfs(sr, sc);
        if(ans == 0) System.out.println("TT");
        else System.out.println(ans);

    }

    private static void bfs(int sr, int sc) {
        visited[sr][sc] = true;

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];

            if(map[r][c] == 'P') {
                ans++;
            }

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(!check(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 'X') continue;

                visited[nr][nc] = true;
                que.offer(new int[] {nr, nc});
            }
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
