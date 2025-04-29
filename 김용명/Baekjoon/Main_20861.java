import java.util.*;
import java.io.*;

class Main_20861 {

    static char [][] map;
    static boolean[][] visited;
    static int n, m;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited = new boolean[n][m];
        int r = 0;
        int c = 0;
        String ans = "";
        while (true) {
            if (map[r][c] == 'A') {
                ans = "sushi";
                break;
            } else if (map[r][c] == 'B') {
                ans = "samuraj";
                break;
            } else if (visited[r][c]) {
                ans = "cykel";
                break;
            }

            visited[r][c] = true;
            if (map[r][c] == '<') {
                r += dr[0];
                c += dc[0];
            } else if (map[r][c] == '>') {
                r += dr[1];
                c += dc[1];
            } else if (map[r][c] == 'v') {
                r += dr[2];
                c += dc[2];
            } else if (map[r][c] == '^') {
                r += dr[3];
                c += dc[3];
            }
        }
        System.out.println(ans);
    }
}