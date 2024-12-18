import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 12927. 배수 스위치 / 실버4 / 12분
// 그리디로 해결
// -1 이 나오는 케이스가 있긴 한지 의문
public class BOJ_12927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean[] arr = new boolean[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            arr[i] = s.charAt(i - 1) == 'Y';
        }
        int count = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (arr[i]) {
                for (int j = i; j <= s.length(); j += i) {
                    arr[j] = !arr[j];
                }
                count++;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);
    }
}
