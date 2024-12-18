import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12851. 숨바꼭질 2 / 골드4 / 43분
// 방문 배열은 꼭 필요할 때만.
// 이 문제의 경우 방문 여부는 중요하지 않다.
// 배열 자체 칸마다 최솟값을 저장하는 테크닉도 길러보자
public class BOJ_12851 {
    static int end;
    static int minTime = Integer.MAX_VALUE;
    static int count;
    static int[] minTimeArr;

    public static void bfs(int here) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{here, 0});
        minTimeArr[here] = 0;

        while (!q.isEmpty()) {
            int cur = q.peek()[0];
            int time = q.poll()[1];

            if (cur == end) {
                if (time < minTime) {
                    minTime = time;
                    count = 1;
                } else if (time == minTime) {
                    count++;
                }
            }

            int[] nextPos = new int[]{cur - 1, cur + 1, cur * 2};
            for (int next : nextPos) {
                if (next >= 0 && next <= 100000) {
                    if (minTimeArr[next] == -1 || minTimeArr[next] >= time + 1) {
                        minTimeArr[next] = time + 1;
                        q.add(new int[]{next, time + 1});
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        minTimeArr = new int[111111];
        Arrays.fill(minTimeArr, -1);
        bfs(start);

        System.out.println(minTime);
        System.out.println(count);
    }
}
