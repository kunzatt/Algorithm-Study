import java.io.*;
import java.util.*;

public class BOJ_10819 {
    public static int maxValue;
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        maxValue = Math.max(maxValue, sum(arr));
        while (nextPermutation(arr)) {
            maxValue = Math.max(maxValue, sum(arr));
        }

        System.out.println(maxValue);
    }

    public static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j--;
        }
        swap(a, j, i - 1);
        j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
        return true;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int sum(int[] arr) {
        int total = 0;
        for (int i = 0; i < n - 1; i++) {
            total += Math.abs(arr[i] - arr[i + 1]);
        }
        return total;
    }
}