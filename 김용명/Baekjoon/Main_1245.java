import java.io.*;
import java.util.*;

public class Main_1245 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean flag;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    flag = true;
                    dfs(i, j);
                    if (flag) count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[x][y] < map[nx][ny]) {
                    flag = false;
                }
                if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
                    dfs(nx, ny);
                }
            }
        }
    }

}