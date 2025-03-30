package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17070_파이프옮기기1 {

    static int N, count;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        dfs(0, 1, 0);
        System.out.println(count);
    }

    private static void dfs(int r, int c, int state) {
        if(r == N-1 && c == N-1) {
            count++;
            return;
        }
        if(state == 0) {
            if(c + 1 < N && map[r][c + 1] == 0) {
                dfs(r, c + 1, 0);
            }
            if(r + 1 < N && c + 1 < N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0) {
                dfs(r + 1, c + 1, 2);
            }
        }
        else if(state == 1) {
            if(r + 1 < N && map[r + 1][c] == 0) {
                dfs(r + 1, c, 1);
            }
            if(r + 1 < N && c + 1 < N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0) {
                dfs(r + 1, c + 1, 2);
            }
        }
        else {
            if(c + 1 < N && map[r][c + 1] == 0) {
                dfs(r, c + 1, 0);
            }
            if(r + 1 < N && map[r + 1][c] == 0) {
                dfs(r + 1, c, 1);
            }
            if(r + 1 < N && c + 1 < N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0) {
                dfs(r + 1, c + 1, 2);
            }
        }
    }
}
