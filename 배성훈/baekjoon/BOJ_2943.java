import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2943. 토끼 / 실버1 / 1시간 30분~
// 은근히 제한 맞추기 힘든 구현.시뮬레이션 문제
public class BOJ_2943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = (int) Math.sqrt(n);
        int[] boxes = new int[n];
        int[] cups = new int[(n + k - 1) / k];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int end = b + s;
            int ans = 0;

            while (s < end && s % k != 0) {
                boxes[s]++;
                ans += boxes[s];
                s++;
            }

            if (end != n) {
                while (s < end && end % k != 0) {
                    end--;
                    boxes[end]++;
                    ans += boxes[end];
                }
            }
            while (s < end) {
                cups[s / k]++;
                ans += cups[s / k];
                s += k;
            }

            System.out.println(ans);

        }
    }
}