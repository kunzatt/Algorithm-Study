import java.io.*;
import java.util.*;

public class Main9205_맥주마시면서걸어가기 {
    static int T, N;
    static int[][] locations;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            locations = new int[N+2][N+2];
            for(int i = 0; i < N+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                locations[i][0] = Integer.parseInt(st.nextToken());
                locations[i][1] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[locations.length];
            System.out.println(bfs(locations) ? "happy" : "sad");
        }
    }

    static boolean bfs(int[][] locations) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        visited[0] = true;

        while(!que.isEmpty()) {
            int curr = que.poll();

            // 페스티벌에 도달했나요
            if(curr == locations.length-1) return true;

            for(int i = 0; i < locations.length; i++) {
                if(visited[i] || distance(locations[curr], locations[i]) > 1000) continue;
                que.offer(i);
                visited[i] = true;
            }
        }

        return false;
    }

    static int distance(int[] r, int[] c) {
        return Math.abs(r[0] - c[0]) + Math.abs(r[1] - c[1]);
    }
}
