package class3;

import java.io.*;
import java.util.*;

public class Boj_18870_좌표압축 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = press(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static int[] press(int[] arr) {

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        HashMap<Integer, Integer> valueToRank = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < sortedArr.length; i++) {
            if (i > 0 && sortedArr[i] == sortedArr[i - 1]) {
                continue;
            }
            valueToRank.put(sortedArr[i], rank++);
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = valueToRank.get(arr[i]);
        }

        return result;
    }
}
