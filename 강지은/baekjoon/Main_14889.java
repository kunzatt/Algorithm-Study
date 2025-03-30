import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14889 {

    static int N, min;
    static int[][] map;
    static List<Integer> select;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        select = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        perm(0, 0);

        System.out.println(min);

    }

    private static void perm(int idx, int cnt) {
        if (cnt == N / 2) {

            int start = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    if (i == j) continue;
                    start += map[select.get(i)][select.get(j)] + map[select.get(j)][select.get(i)];
                }
            }

            int link = 0;
            for (int i = 0; i < N; i++) {
                if (select.contains(i)) continue;
                for (int j = 0; j < N; j++) {
                    if (select.contains(j) || i == j) continue;
                    link += map[i][j] + map[j][i];
                }
            }

            min = Math.min(min, Math.abs(start - link) / 2);

            return;
        }

        for (int i = idx; i < N; i++) {
            if (select.contains(i)) continue;
            select.add(i);
            perm(i + 1, cnt + 1);
            select.remove(cnt);
        }
    }

}
