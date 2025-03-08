package class3;

import java.io.*;
import java.util.*;

public class Boj_18111_마인크래프트 {

    static int N, M ,B, min, max, anst, ansh;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        min = 256;
        max = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        anst = Integer.MAX_VALUE;
        ansh = -1;

        for(int height = min; height <= max; height++) {
            int inventory = B;
            int time = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    int diff = map[i][j] - height;
                    if(diff > 0) {
                        time += diff * 2;
                        inventory += diff;
                    } else if(diff < 0) {
                        time += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            if(inventory >= 0) {
                if(time <= anst) {
                    anst = time;
                    ansh = height;
                }
            }
        }

        System.out.println(anst + " " + ansh);
    }
}