package src.sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_통근버스출발순서검증하기 {

    static int N;
    static int[] bus;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        bus = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bus[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;

        for (int j = 1; j < N - 1; j++) {
            List<Integer> left = new ArrayList<>();
            for (int i = 0; i < j; i++) {
                if (bus[i] < bus[j]) {
                    left.add(bus[i]);
                }
            }

            Collections.sort(left);

            for (int k = j + 1; k < N; k++) {
                int idx = upper(left, bus[k]);
                ans += left.size() - idx;
            }
        }

        System.out.println(ans);
    }

    static int upper(List<Integer> list, int target) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
