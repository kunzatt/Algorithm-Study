import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 13335. 트럭 / 실버1 / 1:22 ~ 2:04
// 큐를 이용해 쉽게 시뮬레이션 할 수 있다.
// 처음에 모두 0을 넣어놓고, 다리에 올릴 수 있는 경우는 해당 요소를, 올리지 못하는 경우는 0을 넣는다.
public class BOJ_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            q.add(0);
        }

        int minTime = 0;
        int totalWeight = 0;
        int idx = 0;
        while (idx < n) {
            totalWeight -= q.poll();
            if (totalWeight + arr[idx] <= l) {
                q.add(arr[idx]);
                totalWeight += arr[idx++];
            } else {
                q.add(0);
            }
            minTime++;
        }
        minTime += q.size();
        System.out.println(minTime);
    }
}
