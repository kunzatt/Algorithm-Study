package class3;

import java.io.*;
import java.util.*;

public class Boj_6064_카잉달력 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = cal(M, N, x, y);
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    public static int cal(int M, int N, int x, int y) {

        int lcm = lcm(M, N);
        int year = x;

        x = x % M == 0 ? M : x % M;
        y = y % N == 0 ? N : y % N;

        while (year <= lcm) {
            int cur = (year % N == 0) ? N : year % N;
            if (cur == y) {
                return year;
            }
            year += M;
        }
        return -1;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}