import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1535 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] power = new int[N + 1];
        int[] happiness = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            happiness[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][100];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 100; j++) {
                if (j + power[i] < 100) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j + power[i]] + happiness[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][0]);

    }
}
