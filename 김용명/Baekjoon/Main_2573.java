import java.io.*;
import java.util.*;

public class Main_2573 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            year++;
            int[][] nmap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        int count = 0;
                        for (int d = 0; d < 4; d++) {
                            int ni = i + dr[d];
                            int nj = j + dc[d];
                            if (map[ni][nj] == 0) {
                                count++;
                            }
                        }
                        nmap[i][j] = Math.max(0, map[i][j] - count);
                    }
                }
            }
            map = nmap;

            int count = dfs();
            if (count == 0) {
                System.out.println(0);
                break;
            } else if (count > 1) {
                System.out.println(year);
                break;
            }
        }
    }

    static int dfs() {
        visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tr = temp[0];
            int tc = temp[1];

            for (int d = 0; d < 4; d++) {
                int nr = tr + dr[d];
                int nc = tc + dc[d];

                if (check(nr, nc) && map[nr][nc] > 0 && !visited[nr][nc]) {
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}