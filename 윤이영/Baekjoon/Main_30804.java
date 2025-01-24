import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_30804 {
    static int N;
    static int[] arr;
    static int[] nums = new int[10]; // 각 과일 번호의 개수를 기록
    static int ans, kinds; // 최대 길이와 현재 구간의 과일 종류 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        kinds = 0;
        int l = 0; // 왼쪽 포인터

        for (int r = 0; r < N; r++) { // 오른쪽 포인터를 이동
            if (nums[arr[r]] == 0) {
                kinds++; // 새로운 종류가 추가되면 종류 수 증가
            }
            nums[arr[r]]++;

            while (kinds > 2) { // 종류가 3개 이상이면 왼쪽 포인터 이동
                nums[arr[l]]--;
                if (nums[arr[l]] == 0) {
                    kinds--; // 종류가 없어지면 감소
                }
                l++;
            }

            // 현재 구간 길이 계산
            ans = Math.max(ans, r - l + 1);
        }

        System.out.println(ans);
    }
}
