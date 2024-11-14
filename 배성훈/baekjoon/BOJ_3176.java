import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// d와 e의 lca를 찾아가면서(lca는 당연히 희소배열로 처리해야한다)
// d에서 lca로 가는 도중 최소간선과 최대 간선 구하고,
// e에서 lca로 가는 도중 최소간선과 최대 간선 구한다.
// 그렇게 구해진 최소간선 2개중 최소 구하고, 최대간선 2개중 최대 구하면 되는데
// 미리 정점과 정점에 대한 간선 전처리를 해놓아야한다(당연히 이것도 희소배열로 처리한다)
public class BOJ_3176 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, logn;
    static List<Edge>[] adj;
    static int[][] parent;
    static int[] depth;
    static Edge[][] minEdge;
    static Edge[][] maxEdge;

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        logn = (int)Math.ceil(Math.log(n) / Math.log(2));
        adj = new List[n+1];
        parent = new int[n+1][logn+1];
        depth = new int[n+1];
        minEdge = new Edge[n+1][logn+1];
        maxEdge = new Edge[n+1][logn+1];

        for (int i=1; i<=n; i++) {
            adj[i]=new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, weight));
            adj[b].add(new Edge(a, weight));
        }
        dfs(1, 0);
        fill();

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int[] result = query(d, e);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.print(sb);
    }

    // 희소배열에서 lca 하면서 최소간선, 최대간선 찾기
    private static int[] query(int d, int e) {
        int minResult = Integer.MAX_VALUE;
        int maxResult = Integer.MIN_VALUE;
        if (depth[d] < depth[e]) {
            int temp = d;
            d = e;
            e = temp;
        }
        // 깊이 차이만큼 d를 올리면서 최소/최대 간선 갱신
        int diff = depth[d] - depth[e];
        for (int j = 0; diff > 0; j++) {
            if ((diff & 1) == 1) {
                if (minEdge[d][j] != null) {
                    minResult = Math.min(minResult, minEdge[d][j].weight);
                    maxResult = Math.max(maxResult, maxEdge[d][j].weight);
                }
                d = parent[d][j];
            }
            diff >>= 1;
        }
        if (d == e) return new int[]{minResult, maxResult};

        // 두 정점을 동시에 올리면서 LCA 바로 아래까지 이동
        for (int j = logn; j >= 0; j--) {
            if (parent[d][j] != parent[e][j]) {
                if (minEdge[d][j] != null) {
                    minResult = Math.min(minResult, minEdge[d][j].weight);
                    maxResult = Math.max(maxResult, maxEdge[d][j].weight);
                }
                if (minEdge[e][j] != null) {
                    minResult = Math.min(minResult, minEdge[e][j].weight);
                    maxResult = Math.max(maxResult, maxEdge[e][j].weight);
                }
                d = parent[d][j];
                e = parent[e][j];
            }
        }

        // 마지막 간선들 처리
        if (minEdge[d][0] != null) {
            minResult = Math.min(minResult, minEdge[d][0].weight);
            maxResult = Math.max(maxResult, maxEdge[d][0].weight);
        }
        if (minEdge[e][0] != null) {
            minResult = Math.min(minResult, minEdge[e][0].weight);
            maxResult = Math.max(maxResult, maxEdge[e][0].weight);
        }
        return new int[]{minResult, maxResult};
    }


    private static void fill() {
        for (int j = 1; j <= logn; j++) {
            for (int i = 1; i <= n; i++) {
                if (parent[i][j - 1] != 0) {
                    parent[i][j] = parent[parent[i][j - 1]][j - 1];
                    int min = Integer.MAX_VALUE;
                    int max = Integer.MIN_VALUE;
                    if (minEdge[i][j - 1] != null) {
                        min = Math.min(min, minEdge[i][j - 1].weight);
                        max = Math.max(max, maxEdge[i][j - 1].weight);
                    }
                    if (minEdge[parent[i][j - 1]][j - 1] != null) {
                        min = Math.min(min, minEdge[parent[i][j - 1]][j - 1].weight);
                        max = Math.max(max, maxEdge[parent[i][j - 1]][j - 1].weight);
                    }
                    if (min != Integer.MAX_VALUE) {
                        minEdge[i][j] = new Edge(parent[i][j], min);
                        maxEdge[i][j] = new Edge(parent[i][j], max);
                    }
                }
            }
        }
    }

    private static void dfs(int cur, int par) {
        parent[cur][0] = par;
        depth[cur] = depth[par] + 1;
        for (Edge next : adj[cur]) {
            if (next.to == par) {
                minEdge[cur][0] = new Edge(par, next.weight);
                maxEdge[cur][0] = new Edge(par, next.weight);
                break;
            }
        }
        for (Edge next : adj[cur]) {
            if (next.to != par) {
                dfs(next.to, cur);
            }
        }
    }
}