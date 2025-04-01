import java.io.*;
import java.util.*;

public class Main_1268 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][5];
        int max = 0;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[i][j] == arr[k][j] && k != i) {
                        set.add(k);
                    }
                }
            }

            if (max < set.size()) {
                max = set.size();
                ans = i;
            }
        }
        System.out.println(ans + 1);
    }
}
