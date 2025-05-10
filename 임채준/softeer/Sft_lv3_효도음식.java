package sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_효도음식 {
	
	static int N;
	static int[] preference;

	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        preference = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            preference[i] = Integer.parseInt(st.nextToken());
        }

        int[] lmax = new int[N];
        int cur = preference[0];
        lmax[0] = cur;
        for (int i = 1; i < N; i++) {
            cur = Math.max(preference[i], cur + preference[i]);
            lmax[i] = Math.max(lmax[i - 1], cur);
        }

        int[] rmax = new int[N];
        cur = preference[N - 1];
        rmax[N - 1] = cur;
        for (int i = N - 2; i >= 0; i--) {
            cur = Math.max(preference[i], cur + preference[i]);
            rmax[i] = Math.max(rmax[i + 1], cur);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N - 2; i++) {
            max = Math.max(max, lmax[i] + rmax[i + 2]);
        }

        System.out.println(max);
    }

}
