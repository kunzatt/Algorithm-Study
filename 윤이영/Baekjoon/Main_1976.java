import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976 {
    static int N, M;
    static int[] p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        p = new int[N];
        int[] travel = new int[M];

        for (int i = 0; i < N; i++) {
            p[i] = i;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            travel[i] = Integer.parseInt(st.nextToken()) - 1; // 1-indexed to 0-indexed
        }

        boolean flag = true;
        for (int i = 0; i < M - 1; i++) {
            if (find(travel[i]) != find(travel[i + 1])) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            p[y] = x;
        }
    }

    private static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }
}
