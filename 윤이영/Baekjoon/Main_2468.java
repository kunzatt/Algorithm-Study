import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0}; 
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        int maxH = 0; //가장 높은 지점
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        int maxsafeArea = 0;

        for (int height = 0; height <= maxH; height++) {
            visited = new boolean[N][N];
            int safeAreas = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > height) {
                        bfs(i, j, height);
                        safeAreas++;
                    }
                }
            }
            maxsafeArea = Math.max(maxsafeArea, safeAreas);
        }
        System.out.println(maxsafeArea);
    }

    static void bfs(int sr, int sc, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(!check(nr, nc)) continue;
                if (!visited[nr][nc] && map[nr][nc] > height) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
                
            }
        }
    }

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
