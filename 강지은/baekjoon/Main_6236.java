import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6236 {

    static int N, M;
    static int[] coin;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coin = new int[N];

        int lo = 0;
        int hi = 0;

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            lo = Math.max(lo, coin[i]);
            hi += coin[i];
        }

        int K = hi;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            int pick = mid;
            int cnt = 1;

            for (int i = 0; i < N; i++) {
                if (pick >= coin[i]) {
                    pick -= coin[i];
                } else {
                    pick = mid;
                    pick -= coin[i];
                    cnt++;
                }
            }

            if (cnt <= M) {
                hi = mid - 1;
                K = Math.min(K, mid);
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(K);
    }

}
