package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] sort1 = new int[n];
        int[] sort2 = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr1[i] = x - y;
            sort1[i] = x - y;
            arr2[i] = x + y;
            sort2[i] = x + y;
        }

        Arrays.sort(sort1);
        Arrays.sort(sort2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = arr1[i], y = arr2[i];
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (sort2[mid] >= x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            sb.append(left + 1).append(" ");

            left = 0;
            right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (sort1[mid] <= y) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(right + 1).append("\n");
        }

        System.out.print(sb);
    }
}
