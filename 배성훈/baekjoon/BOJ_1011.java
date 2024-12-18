import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1011. Fly me to the Alpha Centauri / 골드5 / 56분
// 속도가 턴마다 1씩 증가하거나 감소한다
// 도착하기 전에 속도를 1로 만들어야 한다.
// 즉 필연적으로 중간에서의 속도는 거리의 제곱근이 돼야 한다
// 예를 들어 가야 하는 거리가 11이라고 하면 속도는
// 1 -> 2 -> 3 -> 2 -> 1 순으로 되어야 하기 때문에, 중간 속도는 거리의 제곱근이며 이는 최고 속도이기도 하다.
// 1. 최고 속도로 도달할 수 있는 거리보다 크면, 속도를 한번 더 증가시켜야 하기 때문에 이동 횟수는 2 * 최고속도 + 1이 된다.
// 2. 거리가 정확히 최고속도의 제곱이라면 정확히 그 속도로 이동할 수 있기 때문에 이동횟수는 2 * 최고속도 - 1이다.
// 3. 그 외에는 2 * 최고속도로 이동이 가능하다.
public class BOJ_1011 {
    static long x, y;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            init();
            sb.append(play(x, y)).append("\n");
        }
        System.out.print(sb);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
    }

    public static long play(long x, long y) {
        long dist = y - x;
        long maxSpeed = (int) Math.sqrt(dist);
        if (maxSpeed * maxSpeed + maxSpeed < dist) {
            return 2 * maxSpeed + 1;
        } else if (maxSpeed * maxSpeed == dist) {
            return 2 * maxSpeed - 1;
        } else {
            return 2 * maxSpeed;
        }
    }
}