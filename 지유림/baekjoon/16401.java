import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken());
        L = new int[N]; 
        st = new StringTokenizer(br.readLine());
        int max = 0; 
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, L[i]);
        }

        System.out.println(binarySearch(1, max));;
    }

    static int binarySearch(int left, int right) {
        int result = 0;
        while (left <= right) {
            int mid =  left + (right - left) / 2;
            int cnt = 0;

            for (int i = 0; i < L.length; i++) {
                cnt += L[i] / mid;
            }

            if (cnt >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
