import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 12852. 1로 만들기 2 / 실버1 / 10분
public class BOJ_12852 {
    static final int INF = 1234567891;
    static int minCount = INF;
    static int num;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        bt(num, 0, new ArrayDeque<>());

        System.out.println(minCount);
        System.out.println(ans);
    }

    public static void bt(int num, int count, Deque<Integer> list) {
        // 가지치기
        // 어떤 경우의 수가 이미 저장해놓은 minCount를 넘어간다면 더이상 탐색할 필요가 없다.
        if (count >= minCount) {
            return;
        }

        // 숫자가 1이 되면 경로를 저장하고 탐색 종료
        if (num == 1) {
            StringBuilder sb = new StringBuilder();
            minCount = Math.min(minCount, count);
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append(num);
            ans = sb;
            return;
        }

        // 현재 숫자가 3으로 나누어 떨어진다면 3을 나눈 수로 재귀
        if (num % 3 == 0) {
            list.addLast(num);
            bt(num / 3, count + 1, list);
            list.pollLast();
        }

        // 현재 숫자가 2로 나누어 떨어진다면 2를 나눈 수로 재귀
        if (num % 2 == 0) {
            list.addLast(num);
            bt(num / 2, count + 1, list);
            list.pollLast();
        }

        // 1을 뺀 값으로 재귀
        list.addLast(num);
        bt(num - 1, count + 1, list);
        list.pollLast();
    }
}
