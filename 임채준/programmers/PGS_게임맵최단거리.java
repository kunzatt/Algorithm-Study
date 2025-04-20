import java.util.*;

public class PGS_게임맵최단거리 {

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0, 0, 1});
        visited[0][0] = true;

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            int time = cur[2];

            if(r == n - 1 && c == m - 1) {
                return time;
            }

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if(visited[nr][nc]) continue;
                if(maps[nr][nc] == 0) continue;

                que.offer(new int[] {nr, nc, time + 1});
                visited[nr][nc] = true;
            }
        }

        return -1;
    }

}
