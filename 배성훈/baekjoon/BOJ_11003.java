import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 11003. 최솟값 찾기 / 플래5 / 1시간20분
// 우선순위큐 O(n log n)로도 통과 못하는 악질 문제(N이 500만개까지 주어져서 그럴만 하다)
// 정석은 Deque 을 우선순위큐처럼 동작하게 사용하는 것으로 보인다
// 이유는 우선순위큐는 add 와 poll 연산 모두 log n 으로 수행한다 -> 평균적으로 성능은 좋지만 최선의 경우에도 그렇게 작동한다는 것이 문제
// 어차피 최솟값을 찾는게 목적이니 앞뒤 연산이 모두 가능하고 O(1)로 작동하는 Deque 으로 맨앞에 최솟값이 오게 계속 관리해주기~
// 또 다른 핵심은 값을 저장하지 말고 해당 인덱스를 저장하는 것
// 이유는 값으론 20억의 범위를 커버할 수 없으니까, 값의 인덱스를 저장해 해당 인덱스가 탐색하고자하는 범위를 벗어나면 없애준다
public class BOJ_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> d = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // 덱의 맨 앞 인덱스가 탐색하고자 하는 범위를 벗어났다면 빼내준다
            if (!d.isEmpty() && d.peekFirst() <= i - l) {
                d.pollFirst();
            }
            // 덱의 맨 앞의 요소가 항상 제일 작은 값이 오도록 유지
            // 그러기 위해 현재 추가해야하는 값이 덱의 맨 끝값보다 클 때까지 맨끝에서 빼주기
            while (!d.isEmpty() && arr[d.peekLast()] > arr[i]) {
                d.pollLast();
            }
            // 인덱스 추가
            d.addLast(i);
            sb.append(arr[d.peekFirst()]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
