import java.util.*;
import java.io.*;
class Main_2617 {
    static int N, M, K;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] rgraph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = (N + 1) / 2;

        graph = new ArrayList[N + 1];
        rgraph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            rgraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            rgraph[end].add(start);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            if (dfs(i, rgraph) >= K) {
                ans++;
                continue;
            }

            visited = new boolean[N + 1];
            visited[i] = true;
            if (dfs(i, graph) >= K) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static int dfs(int num, ArrayList<Integer>[] graph) {
        int count = 0;

        for (int next : graph[num]) {
            if (!visited[next]) {
                visited[next] = true;
                count += 1 + dfs(next, graph);

                if (count >= K) break;
            }
        }
        return count;
    }
}