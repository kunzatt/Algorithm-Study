import java.io.*;
import java.util.*;

public class Main_15565 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        int left = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) count++;
            while (count >= K) {
                int length = i - left + 1;
                min = Math.min(min, length);

                if (arr[left] == 1) count--;
                left++;
            }
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}
