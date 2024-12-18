import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 14002. 가장 긴 증가하는 부분 수열 4 / 골드4 / 1시간 40분
// 길이를 구하는 로직은 굉장히 쉽지만 요소를 출력하는 건 어렵다
// 길이가 갱신될 떄마다 이전 인덱스들을 저장해놓고 타고가면서 저장해야한다.
public class BOJ_14002 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }
        int maxLen = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }
        List<Integer> lis = new ArrayList<>();
        while (maxIdx != -1) {
            lis.add(arr[maxIdx]);
            maxIdx = prev[maxIdx];
        }
        Collections.reverse(lis);
        System.out.println(maxLen);
        for (Integer li : lis) {
            System.out.print(li + " ");
        }
    }
}