import java.util.Scanner;

// 1309. 동물원 / 실버1 / 40분
// 전형적인 DP 문제다.
// DP의 핵심은 이전의 값을 무엇을 저장하며, 어떻게 재활용해서 현재의 값을 뽑아낼 것인지 점화식을 잘 세울 것!
public class BOJ_1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i <= n; i++) {
            dp[i] = ((dp[i - 1] * 2) + dp[i - 2]) % 9901;
        }
        System.out.println(dp[n]);
    }
}
