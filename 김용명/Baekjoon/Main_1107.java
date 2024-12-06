import java.io.*;
import java.util.*;

public class Main_1107 {

    static int N, M, count, ans;
    static boolean[] nums;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        nums = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                nums[Integer.parseInt(st.nextToken())] = true;
            }
        }

        ans = Math.abs(N-100);

        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);

            boolean check = false;

            for (int j = 0; j < str.length(); j++) {
                if (nums[str.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                int result = Math.abs(N-i) + str.length();
                ans = Math.min(ans, result);
            }

        }

        System.out.println(ans);

    }

}

