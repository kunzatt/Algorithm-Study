package sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_업무처리 {

    static int H, K, R;
    static Queue<Integer>[] works;
    static Queue<Integer>[][] wait;
    static long result = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int size = (1 << (H + 1));
        works = new LinkedList[size];
        wait = new LinkedList[size][2];

        for (int i = 1; i < size; i++) {
            works[i] = new LinkedList<>();
            wait[i][0] = new LinkedList<>();
            wait[i][1] = new LinkedList<>();
        }

        int leaf = (1 << H);
        for (int i = 0; i < (1 << H); i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                works[leaf + i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int d = 1; d <= R; d++) {
            int side = (d % 2 == 1) ? 0 : 1;
            if (!wait[1][side].isEmpty()) {
                result += wait[1][side].poll();
            }

            List<int[]> tempTasks = new ArrayList<>();

            for (int i = 2; i < leaf; i++) {
                side = (d % 2 == 1) ? 0 : 1;
                if (!wait[i][side].isEmpty()) {
                    int taskId = wait[i][side].poll();
                    int parent = i / 2;
                    int childSide = (i % 2 == 0) ? 0 : 1;

                    tempTasks.add(new int[]{parent, taskId, childSide});
                }
            }

            for (int[] task : tempTasks) {
                int parent = task[0];
                int taskId = task[1];
                int childSide = task[2];
                wait[parent][childSide].add(taskId);
            }

            tempTasks.clear();

            for (int i = leaf; i < size; i++) {
                if (!works[i].isEmpty()) {
                    int taskId = works[i].poll();
                    int parent = i / 2;
                    int childSide = (i % 2 == 0) ? 0 : 1;

                    tempTasks.add(new int[]{parent, taskId, childSide});
                }
            }

            for (int[] task : tempTasks) {
                int parent = task[0];
                int taskId = task[1];
                int childSide = task[2];
                wait[parent][childSide].add(taskId);
            }
        }

        System.out.println(result);
    }
}
