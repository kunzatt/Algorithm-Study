import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 1417. 국회의원 선거 / 실버5 / 5분
// 가장 큰 것을 계속해서 갱신해서 찾아주고 빼줘야 한다.
// 빼낼 때마다 정렬을 해도 되겠지만 그럴 때 쓰기 좋은 우선순위 큐 사용
public class BOJ_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        while (!pq.isEmpty() && dasom <= pq.peek()) {
            pq.add(pq.poll() - 1);
            dasom++;
            count++;
        }
        System.out.println(count);
    }
}
