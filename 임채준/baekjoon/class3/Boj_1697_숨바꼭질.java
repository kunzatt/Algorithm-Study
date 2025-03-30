package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697_숨바꼭질 {

    static int N, K, min, MAX = 100001;
    static Queue<int[]> que;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        min = Integer.MAX_VALUE;
        bfs(N, 0);
        System.out.println(min);

    }

    private static void bfs(int start, int move) {
        que = new LinkedList<>();
        que.offer(new int[] {start, move});
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int loc = cur[0];
            int count = cur[1];
            if(loc == K) {
                min = Math.min(min, count);
                continue;
            }
            if(loc * 2 < MAX && !visited[loc * 2]) {
                visited[loc * 2] = true;
                que.offer(new int[] {loc * 2, count + 1});
            }
            if(loc - 1 >= 0 && !visited[loc - 1]) {
                visited[loc - 1] = true;
                que.offer(new int[] {loc  - 1, count + 1});
            }
            if(loc + 1 < MAX && !visited[loc + 1]) {
                visited[loc + 1] = true;
                que.offer(new int[] {loc + 1, count + 1});
            }
        }

    }

}
