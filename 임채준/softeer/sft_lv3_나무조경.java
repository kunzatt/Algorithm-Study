package src.sft;

import java.io.*;
import java.util.*;

public class sft_lv3_나무조경 {

    static int n, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        visited = new boolean[n][n];
        backtrack(0, 0, 0);
        System.out.println(answer);

    }

    public static void backtrack(int count, int total, int start){
        if(count == 4){
            answer = Math.max(answer, total);
            return;
        }

        for(int i = start; i < n * n; i++){
            int r = i / n;
            int c = i % n;
            if(visited[r][c]) continue;
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(check(nr, nc) && !visited[nr][nc]){
                    visited[r][c] = true;
                    visited[nr][nc] = true;
                    int sum = map[r][c] + map[nr][nc];
                    backtrack(count + 1, total + sum, i + 1);
                    visited[r][c] = false;
                    visited[nr][nc] = false;
                }
            }
        }
        answer = Math.max(answer, total);
    }

    public static boolean check(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}
