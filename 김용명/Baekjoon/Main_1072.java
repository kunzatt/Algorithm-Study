import java.io.*;
import java.util.*;

public class Main_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = (Y * 100) / X;

        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 0;
        long right = X;
        long ans = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long temp = ((Y + mid) * 100) / (X + mid);

            if (temp > Z) {
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}