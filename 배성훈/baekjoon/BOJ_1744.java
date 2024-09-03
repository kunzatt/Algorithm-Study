import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 1744. 수 묶기 / 골드4 / 5:53~6:54
// 우선순위 큐 사용
// 핵심은 곱했을 때 결괏값이 가장 큰 두수부터 묶어야 한다
// 그러기 위해 음수값을 따로 저장하는 음수 우선순위 큐와 양수값을 따로 저장하는 양수 우선순위 큐 정의
// 각각 절댓값이 큰 순서대로 두개를 곱하게 poll 연산
// + 주의점은 0도 우선순위 큐에 들어가게 해줘야하고, 1은 곱했을 때보다 따로 더했을 때 값이 더 크므로 따로 더하기
public class BOJ_1744 {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        PriorityQueue<Integer> plusQ = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] <= 0) {
                minusQ.offer(arr[i]);
            } else if (arr[i] > 1) {
                plusQ.offer(arr[i]);
            } else {
                sum += arr[i];
            }
        }
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }
        while (minusQ.size() >= 2) {
            sum += minusQ.poll() * minusQ.poll();
        }
        while (plusQ.size() >= 2) {
            sum += plusQ.poll() * plusQ.poll();
        }
        while (!minusQ.isEmpty()) {
            sum += minusQ.poll();
        }
        while (!plusQ.isEmpty()) {
            sum += plusQ.poll();
        }
        System.out.println(sum);
    }

    public static void query(int start, int end) {
        if (start < end) {
            int pivot = partition(start, end);
            query(start, pivot - 1);
            query(pivot + 1, end);
        }
    }

    public static int partition(int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, end);
        return i + 1;
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
