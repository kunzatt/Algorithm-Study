import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1006. 습격자 초라기 / 플래3 / 3시간 ~
// 1년 전에 포기했었던 문제 재도전
// 특수 부대는 w 가 받쳐주는 선에서 한팀이 두 구역까지 가능할 때, 모든 구역을 커버하는 특수부대 최소 개수를 구하는 문제
// 우선 3가지의 특수부대가 최소가 되는 경우의 수를 구한다
// 문제에서는 원형 배열에 대해 얘기하고 있으니,
//      1. 마지막 열과 첫 열이 걸치지 않는 경우,
//      2. 마지막 열과 첫 열의 위 행이 걸치는 경우
//      3. 마지막 열과 첫 열의 아래 행이 걸치는 경우
//      4. 마지막 열과 첫 열의 위 아래 행이 모두 걸치는 경우
// 이 4가지에 대해서도 각각 최솟값을 dp 를 이용해 구하면 된다.
public class BOJ_1006 {
    static final int INF = Integer.MAX_VALUE - 1111111;
    static int[][] dp;
    static int[][] arr;
    static int n, w;

    public static void fill() {
        for (int i = 1; i < n; i++) {
            int up = arr[0][i - 1] + arr[0][i] <= w ? 1 : 2;
            int down = arr[1][i - 1] + arr[1][i] <= w ? 1 : 2;
            int both = arr[0][i] + arr[1][i] <= w ? 1 : 2;

            dp[0][i] = Math.min(dp[1][i - 1] + up, dp[2][i - 1] + 1);
            dp[1][i] = Math.min(dp[0][i - 1] + down, dp[2][i - 1] + 1);
            dp[2][i] = Math.min(dp[2][i - 1] + both,
                    Math.min(dp[0][i] + 1, Math.min(dp[1][i] + 1, dp[2][i - 2 < 0 ? n - 1 : i - 2] + up + down)));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            dp = new int[3][n];
            arr = new int[2][n];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if (n == 1) {
                System.out.println(arr[0][0] + arr[1][0] <= w ? 1 : 2);
                continue;
            }
            int ans = INF;
            dp[0][0] = dp[1][0] = dp[2][0] = INF;

            // 1. 양옆에 걸치지 않는 경우
            dp[0][0] = dp[1][0] = 1;
            dp[2][0] = arr[0][0] + arr[1][0] <= w ? 1 : 2;
            fill();
            ans = Math.min(ans, dp[2][n - 1]);

            // 2. 위 행이 걸칠 경우
            if (arr[0][n - 1] + arr[0][0] <= w) {
                dp[0][0] = 1;
                dp[1][0] = INF;
                dp[2][0] = 2;
                fill();
                ans = Math.min(ans, dp[1][n - 1]);
            }

            // 3. 아래 행이 걸칠 경우
            if (arr[1][n - 1] + arr[1][0] <= w) {
                dp[0][0] = INF;
                dp[1][0] = 1;
                dp[2][0] = 2;
                fill();
                ans = Math.min(ans, dp[0][n - 1]);
            }

            // 4. 둘다 걸칠 경우
            if (arr[0][n - 1] + arr[0][0] <= w && arr[1][n - 1] + arr[1][0] <= w) {
                dp[1][0] = dp[0][0] = INF;
                dp[2][0] = 2;
                fill();
                ans = Math.min(ans, dp[2][n - 2]);
            }
            System.out.println(ans);
        }
    }
}
