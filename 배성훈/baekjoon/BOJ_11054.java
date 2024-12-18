import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11054. 가장 긴 바이토닉 부분 수열 / 골드4 / 47분
// ↗↘ 이렇게 증가하다가 감소하는 부분 수열의 최대 길이를 찾는 문제이다
// 모든 (증가하는 부분 수열의 길이 + 감소하는 부분 수열의 길이) 중 최댓값을 찾으면 된다
// 부분 수열의 길이는 2중 for 문으로 쉽게 구할 수 있다(시간 복잡도를 줄이고 싶으면 이분 탐색으로 구현)
// 여기서, 감소하는 부분 수열의 길이는 인덱스의 반대에서부터 시작해 증가하는 걸로 구현해놓는 것이 더 편하다
// 길이의 최댓값은 lis 배열을 순회하면서, lis[i] + lds[i] - 1 을 해주면 된다(-1을 해주는 이유는 인덱스가 겹치기 때문이다)
public class BOJ_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n]; // 증가하는 부분 수열의 길이 값들을 저장
        int[] lds = new int[n]; // 감소하는 부분 수열의 길이 값들을 저장

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lis[i] = lds[i] = 1;
        }

        // 증가/감소하는 부분 수열의 길이는 원래의 값 뒤에 해당 값을 붙일 수 있는지를 판단하고,
        // 길이 값을 저장한 배열의 원래 인덱스 + 1 을 해준다
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    lis[j] = Math.max(lis[j], lis[i] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    lds[j] = Math.max(lds[j], lds[i] + 1);
                }
            }
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, lis[i] + lds[i] - 1); // i가 중복되는 부분을 제거
        }

        System.out.println(maxLen);
    }
}