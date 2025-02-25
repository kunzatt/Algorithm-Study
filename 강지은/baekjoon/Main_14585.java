import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14585 {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[301][301];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x + y <= M) {
                map[x][y] = M - (x + y);
            }
        }

        map[1][0] += map[0][0];
        map[0][1] += map[0][0];

        for (int i = 1; i < 301; i++) {
            for (int j = 1; j < 301; j++) {
                map[i][j] += Math.max(map[i - 1][j], map[i][j - 1]);
            }
        }

        System.out.println(map[300][300]);
    }
}
