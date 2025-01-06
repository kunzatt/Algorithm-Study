import java.io.*;
import java.util.*;

public class BOJ_13023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            if (play(i, adj)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean play(int start, List<Integer>[] adj) {
        boolean[] visited = new boolean[adj.length];
        List<Integer> path = new ArrayList<>();
        return dfs(start,visited,adj,path);
    }

    private static boolean dfs(int cur, boolean[] visited, List<Integer>[] adj, List<Integer> path) {
        visited[cur] = true;
        path.add(cur);
        if (path.size() == 5) {
            return true;
        }
        for (int next : adj[cur]) {
            if (!visited[next]) {
                if (dfs(next, visited, adj, path)) {
                    return true;
                }
            }
        }
        path.remove(path.size() - 1);
        visited[cur]=false;
        return false;
    }
}