import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 15685. 드래곤 커브 / 골드3 / 70분~
// 드래곤 커브가 생기는 과정을 방향으로 기록하고, 방향에 따라 배열 값을 채운 뒤 4칸이 1로 채워져있는 경우들을 모두 세주면 되는 문제이다.
// 1세대 드래곤 커브까지는 쉽게 이해할 수 있다.
// 2세대 드래곤 커브부터는 규칙이 이때까지 생긴 드래곤 커브들의 역순으로 (해당 선분의 방향 + 1)로 방향이 기록된다.
// 입력에서 주어지는 n 까지 규칙에 따라 드래곤 커브들의 방향들을 저장하고 값을 기록하면 된다!
// 단 주의해야할 점은 주어지는 방향은 0세대 드래곤 커브들의 시작 방향이므로, 그 방향을 기준으로 드래곤 커브들을 만들어야 한다
public class BOJ_15685 {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] arr = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            List<Integer> dirs = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dirs.add(dir);
            int num = 0;
            while (num < g) {
                int size = dirs.size();
                for (int j = size - 1; j >= 0; j--) {
                    dirs.add((dirs.get(j) + 1) % 4);
                }
                num++;
            }
            arr[startY][startX] = 1;
            for (Integer d : dirs) {
                startY += dy[d];
                startX += dx[d];
                arr[startY][startX] = 1;
            }
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i][j + 1] == 1 && arr[i + 1][j + 1] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
