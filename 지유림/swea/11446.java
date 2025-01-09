import java.io.*;
import java.util.*;

public class Solution_사탕가방 {
    static int T, N;
    static long M;
    static long[] candy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Long.parseLong(st.nextToken());

            candy = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                candy[i] = Long.parseLong(st.nextToken());
            }

            long result = binarySearch();
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    static long binarySearch() {
        long left = 1;
        long right = Long.MAX_VALUE;
        long result = 0;

        while(left <= right) {
            long mid = left + (right - left) / 2;

            if(check(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    static boolean check(long cnt) {
        long sum = 0;

        for(int i = 0; i < N; i++) {
            sum += candy[i] / cnt;
            if(sum >= M) return true;
        }

        return sum >= M;
    }
}
