import java.io.*;
import java.util.*;

public class Main_16564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        if (N == 1) {
            System.out.println(arr[0] + K);
            return;
        }

        int left = arr[0];
        int right = arr[0] + K;
        int ans = arr[0];

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] < mid) sum += (mid - arr[i]);
            }

            if (sum <= K) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}