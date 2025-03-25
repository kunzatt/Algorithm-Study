package class3;

import java.io.*;
import java.util.*;

public class BOJ_1074_Z {

    static int N, r, c;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        find(0, 0, size, 0);

        System.out.println(answer);
    }

    public static void find(int y, int x, int size, int count) {

        if (size == 1) {
            answer = count;
            return;
        }

        int newSize = size / 2;
        int area = newSize * newSize;

        if (r < y + newSize && c < x + newSize) {
            find(y, x, newSize, count);
        } else if (r < y + newSize && c >= x + newSize) {
            find(y, x + newSize, newSize, count + area);
        } else if (r >= y + newSize && c < x + newSize) {
            find(y + newSize, x, newSize, count + area * 2);
        } else {
            find(y + newSize, x + newSize, newSize, count + area * 3);
        }
    }
}