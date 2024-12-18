import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 2635. 수 이어가기 / 실버5 / 11분
// 브루트포스로 간단하게 해결할 수 있다
public class BOJ_2635 {
    public static void main(String[] args) throws IOException {
        List<Integer> ans = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int maxCnt = 0;
        for (int i = n / 2; i <= n; i++) {
            List<Integer> nums = new ArrayList<>();
            nums.add(n);
            nums.add(i);
            int idx = 0;
            int count = 2;
            while (true) {
                int num = nums.get(idx) - nums.get(idx + 1);
                if (num < 0) {
                    break;
                }
                nums.add(num);
                count++;
                idx++;
            }
            if (maxCnt < count) {
                maxCnt = count;
                ans.clear();
                ans.addAll(nums);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n");
        for (Integer an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
    }
}
