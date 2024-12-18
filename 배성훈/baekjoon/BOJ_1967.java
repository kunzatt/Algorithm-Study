import java.io.*;
import java.util.*;

// 백준 1967. 트리의 지름
// 플로이드-워셜 알고리즘으로 쉽게 풀린다
// 각 노드마다 DFS 하면서 최대 지름을 갱신해주면 끝
public class BOJ_1967 {
    static List<List<int[]>> list = new ArrayList<>();
    static boolean[] visited;
    static int n;
    static int maxDiameter = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b, w});
            list.get(b).add(new int[]{a, w});
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            dfs(i, 0);
        }

        System.out.println(maxDiameter);
    }

    public static void dfs(int x, int total) {
        visited[x] = true;
        maxDiameter = Math.max(maxDiameter, total);
        List<int[]> arr = list.get(x);

        for (int i = 0; i < arr.size(); i++) {
            int next = arr.get(i)[0];
            int cost = arr.get(i)[1];
            if (!visited[next]) {
                dfs(next, total + cost);
            }
        }
    }

}
