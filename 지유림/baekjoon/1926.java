import java.io.*;
import java.util.*;

public class Main1926_그림 {
    static int N, M;
    static int[][] picture;
    static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        picture = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(picture[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(i, j));
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static int bfs(int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r, c});
        visited[r][c] = true;
        int count = 1;

        while(!que.isEmpty()) {
            int[] cur = que.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + drc[d][0];
                int nc = cur[1] + drc[d][1];

                if(!check(nr, nc) || visited[nr][nc] || picture[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                count++;
                que.offer(new int[]{nr, nc});
            }
        }

        return count;
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
