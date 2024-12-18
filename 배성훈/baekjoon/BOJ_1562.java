import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1562. 계단 수 / 골드1 / 1시간 49분
// '쉬운 계단 수' 문제보다 조건이 하나 더 추가되었다..
// 필드를 추가해서 3차원 dp 배열로 풀자
// 어떤 필드를 추가해야 좋을까? -> 0부터 9까지 모든 숫자가 나온 숫자를 기록해야하니, 각 수의 길이가 1씩 추가됨에 따라 어떤 수가 추가되었는지를 모두 비트필드로 기록하자
// 즉 3차원 배열의 3번째 배열 값은 10칸의 비트필드(0~9)를 비트마스크한 값들이 저장될 것이다.
// 1024(2^10) 칸을 사용하면서, 현재 시점에서 어느 숫자들이(0~9) 켜져있는지에 대한 정보를 저장한다
// 가령, 뒤에서 두번째 칸과 세번째 칸이 켜져있다면(0000000110), 이는 길이가 i인 숫자 맨 뒤에 j 값이 추가되었을 때 2와 1만 가지고 있다는 말이 된다.
// 그리고 0000000110 은 10진수로 표현하면 5이므로, dp[i][j][5] 에다 값이 채워진다고 볼 수 있겠다.
public class BOJ_1562 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][][] dp = new long[n + 1][10][1 << 10];

        // 길이 1일 때 0은 제외
        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        // 길이 2 이상인 계단수 확인
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    if (j == 0) {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k];
                        dp[i][j][k | (1 << j)] %= MOD;
                    } else if (j == 9) {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k];
                        dp[i][j][k | (1 << j)] %= MOD;
                    } else {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k];
                        dp[i][j][k | (1 << j)] %= MOD;
                        dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k];
                        dp[i][j][k | (1 << j)] %= MOD;
                    }
                }
            }
        }
        long sum = 0;
        int full = (1 << 10) - 1;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i][full];
            sum %= MOD;
        }
        System.out.println(sum);
    }
}