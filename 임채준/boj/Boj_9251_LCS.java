package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_9251_LCS {

    static String s1, s2;
    static int len1, len2;
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        len1 = s1.length() + 1;
        len2 = s2.length() + 1;
        dp = new int[len1][len2];

        for(int i = 1; i < len1; i++){
            for(int j = 1; j < len2; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1]  + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 두 개의 문자열 1, 2 중 1을 기준으로 1의 문자역을 맨 처음 글자 1개부터 시작하여 2의 모든 문자를 비교해가며 비교 할때까지의 LCS를 저장해가는 구조
        // 즉 ACAYKP와 CAPCAK의 LCS를 구하고자 할 때, A와C, A와CA, A와CAP, A와CAPC, A와CAPCA, A와CAPCAK, AC와A ..
        // 이렇게 비교 할때마다의 LCS의 길이를 저장해가며 마지막 각 문자열 간의 LCS를 구하는 것

        System.out.println(dp[len1 - 1][len2 - 1]);

    }

}
