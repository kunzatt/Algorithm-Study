import java.io.*;
import java.util.*;

// 3780. 네트워크 연결 / 플래5 / 1시간38분
// DSU
public class BOJ_3780 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] p, d;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            p = new int[n + 1];
            d = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                p[i] = i;
                d[i] = 0;
            }

            while (true) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                if (c == 'O') {
                    break;
                }
                if (c == 'E') {
                    int num = Integer.parseInt(st.nextToken());
                    find(num);
                    bw.write(d[num] + "\n");
                } else if (c == 'I') {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    union(a, b);
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int x) {
        if (p[x] == x) {
            return x;
        }
        int root = find(p[x]);
        d[x] += d[p[x]];
        return p[x] = root;
    }

    private static void union(int a, int b) {
        d[a] = Math.abs(a - b) % 1000;
        p[a] = b;
    }

}