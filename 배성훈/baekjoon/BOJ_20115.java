import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 20115. 에너지 드링크 / 실버3 / 10분
// 가장 큰 값에 다 때려 박으면 끝!
public class BOJ_20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            arr[n - 1] += arr[i] / 2;
        }
        System.out.println(arr[n - 1]);
    }
}
