import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 14916. 거스름돈 / 실버5 / 6분
// 그리디 문제는 어떨 때 최적의 해가 되는지 그 시점만 찾으면 쉽다!
public class BOJ_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int standard = 5 * (n / 5);
        while (standard > 0 && (n - standard) % 2 != 0) {
            standard -= 5;
        }
        int count = standard / 5;
        n -= standard;
        if (n % 2 == 0) {
            count += n / 2;
        }
        System.out.println(count > 0 ? count : -1);
    }
}