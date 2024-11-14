import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_20055 {
    static int N, K;
    static int step = 0;
    static LinkedList<Belt> list = new LinkedList<>();

    static class Belt {
        boolean robot;
        int power;

        public Belt(int power) {
            robot = false;
            this.power = power;
        }

        public void putRobot() {
            robot = true;
            power--;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            int t = Integer.parseInt(st.nextToken());
            list.add(new Belt(t));
        }

        while (true) {
            step++;
            // 1. 벨트 회전
            list.addFirst(list.removeLast());
            if (list.get(N - 1).robot) {
                list.get(N - 1).robot = false;
            }

            // 2. 로봇 이동
            moveRobot();

            // 3. 올리는 위치에 로봇 올리기
            if (list.get(0).power > 0 && !list.get(0).robot) {
                list.get(0).putRobot();
            }

            // 4. 내구도가 0인 벨트가 K개 이상이면 종료
            if (check()) break;
        }

        System.out.println(step);
    }

    private static void moveRobot() {
        for (int i = N - 2; i >= 0; i--) {
            if (list.get(i).robot && !list.get(i + 1).robot && list.get(i + 1).power > 0) {
                list.get(i).robot = false;
                list.get(i + 1).putRobot();
            }
        }
        if (list.get(N - 1).robot) {
            list.get(N - 1).robot = false;
        }
    }

    private static boolean check() {
        int count = 0;
        for (Belt belt : list) {
            if (belt.power == 0) {
                count++;
            }
        }
        return count >= K;
    }
}
