package src.sft;

import java.io.*;
import java.util.*;

public class sft_lv3_택배마스터광우 {

    static int N, M, K;
    static int[] rail;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] order;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        rail = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rail[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        order = new int[N];

        permutation(0);

        System.out.println(min);
    }

    static void permutation(int depth) {
        if (depth == N) {
            cal();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = rail[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    static void cal() {
        int total = 0;
        int count = 0;
        int idx = 0;
        while (count < K) {
            int cur = 0;
            while (true) {
                if (cur + order[idx] <= M) {
                    cur += order[idx];
                    total += order[idx];
                    idx = (idx + 1) % N;
                } else {
                    break;
                }
            }
            count++;
        }
        min = Math.min(min, total);
    }
}