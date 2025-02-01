package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ_1099 {
    static String s;
    static String[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        dp = new int[s.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int result = solve();
        System.out.println(result);
    }

    static int solve() {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String word : arr) {
                int len = word.length();
                if (i + len <= n) {
                    String sub = s.substring(i, i + len);
                    int cost = getCost(word, sub);

                    if (cost != Integer.MAX_VALUE) {
                        dp[i + len] = Math.min(dp[i + len], dp[i] + cost);
                    }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    static int getCost(String word, String sub) {
        if (word.length() != sub.length()) {
            return Integer.MAX_VALUE;
        }

        char[] a = word.toCharArray();
        char[] b = sub.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        if (!Arrays.equals(a, b)) {
            return Integer.MAX_VALUE;
        }

        int cost = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != sub.charAt(i)) {
                cost++;
            }
        }

        return cost;
    }
}
