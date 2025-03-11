package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1689 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n*2][2];
        for(int i = 0; i < n; i++) {
            points[i*2][0] = sc.nextInt();
            points[i*2][1] = 1;
            points[i*2+1][0] = sc.nextInt();
            points[i*2+1][1] = -1;
        }
        Arrays.sort(points, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int count = 0;
        int max = 1;
        for(int i = 0; i < points.length; i++) {
            count += points[i][1];
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
