package class3;

import java.io.*;
import java.util.*;

public class Boj_14940_쉬운최단거리 {

    static int n, m;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map, answer;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int sr = 0;
        int sc = 0;
        map = new int[n][m];
        answer = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) answer[i][j] = -1;
                if(map[i][j] == 2) {
                    answer[i][j] = 0;
                    sr = i;
                    sc = j;
                }
            }
        }

        bfs(sr, sc);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(j != m - 1) {
                    sb.append(answer[i][j]).append(" ");
                } else {
                    sb.append(answer[i][j]);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void bfs(int sr, int sc) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {sr, sc, 0});
        visited[sr][sc] = true;
        
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(!check(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0) continue;
                
                visited[nr][nc] = true;
                answer[nr][nc] = cnt + 1;
                que.offer(new int[] {nr, nc, cnt + 1});
            }
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}