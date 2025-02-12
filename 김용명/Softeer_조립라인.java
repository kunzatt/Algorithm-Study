import java.io.*;
import java.util.*;

public class Softeer_조립라인 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        int[] atob = new int[N];
        int[] btoa = new int[N];
        StringTokenizer st;

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            atob[i] = Integer.parseInt(st.nextToken());
            btoa[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        a[N - 1] = Integer.parseInt(st.nextToken());
        b[N - 1] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][2];
        dp[0][0] = a[0];
        dp[0][1] = b[0];

        for (int i = 0; i < N - 1; i++) {
            dp[i + 1][0] = Math.min(dp[i][0], dp[i][1] + btoa[i]);
            dp[i + 1][0] += a[i + 1];

            dp[i + 1][1] = Math.min(dp[i][1], dp[i][0] + atob[i]);
            dp[i + 1][1] += b[i + 1];
        }

        int ans = Math.min(dp[N - 1][0], dp[N - 1][1]);

        System.out.println(ans);

    }
}