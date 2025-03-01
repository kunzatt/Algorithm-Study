import java.io.*;
import java.util.*;

public class Main9461_파도반수열 {
    static int N, T;
    static long[] P = new long[101];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            P[0] = 0L;
            P[1] = 1L;
            P[2] = 1L;
            P[3] = 1L;

            for(int i = 4; i < P.length; i++) {
                P[i] = -1;
            }

            sb.append(dfs(N) + "\n");
        }

        System.out.println(sb.toString());
    }

    static long dfs(int idx) {
        if(P[idx] == -1) {
            P[idx] = dfs(idx-2) + dfs(idx-3);
        }

        return P[idx];
    }
}
