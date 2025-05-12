package sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_조립라인 {

    static int N;
    static int[] at, bt, atb, bta, dpa, dpb;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        at = new int[N];
        bt = new int[N];
        atb = new int[N];
        bta = new int[N];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            at[i] = Integer.parseInt(st.nextToken());
            bt[i] = Integer.parseInt(st.nextToken());
            atb[i] = Integer.parseInt(st.nextToken());
            bta[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        at[N - 1] = Integer.parseInt(st.nextToken());
        bt[N - 1] = Integer.parseInt(st.nextToken());

        dpa = new int[N];
        dpb = new int[N];

        dpa[0] = at[0];
        dpb[0] = bt[0];

        for (int i = 1; i < N; i++) {
            dpa[i] = Math.min(dpa[i - 1] + at[i], dpb[i - 1] + bta[i - 1] + at[i]);
            dpb[i] = Math.min(dpb[i - 1] + bt[i], dpa[i - 1] + atb[i - 1] + bt[i]);
        }

        System.out.println(Math.min(dpa[N - 1], dpb[N - 1]));

    }
}
