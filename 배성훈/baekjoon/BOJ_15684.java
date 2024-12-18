import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15684. 사다리 조작 / 골드3 / 2시간~
// 백트래킹 + 구현
// 백트래킹으로 탐색을 한다고 해도 끝이 아닌, 백트래킹 후에 각각 완전탐색을 해서 사다리들이 제대로 자신 번호로 가는지를 확인해야하는 까다로운 문제
// 또 설치할 사다리는 실제로 한칸을 차지해야 해서 실제 범위를 한칸씩 늘려서 판단해야 했기 때문에 잔실수가 많았었다.
public class BOJ_15684 {
    static int[][] arr;
    static int n, m, ladder;
    static int minCount = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        ladder = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m *= 2;
        arr = new int[n + 1][m + 1];
        for (int i = 1; i < m; i += 2) {
            for (int j = 0; j <= n; j++) {
                arr[j][i] = 1;
            }
        }
        for (int i = 0; i < ladder; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) * 2;
            arr[a][b] = 1;
        }
        play(1, 2, 0);
        System.out.println(minCount == 4 ? -1 : minCount);
    }

    public static void play(int y, int x, int count) {
        if (count >= minCount) {
            return;
        }
        if (isValid()) {
            minCount = Math.min(minCount, count);
            return;
        }
        for (int i = y; i <= n; i++) {
            for (int j = (i == y ? x : 2); j < m; j += 2) {
                if (arr[i][j] == 0 && arr[i][j - 2] == 0 && arr[i][j + 2] == 0) {
                    arr[i][j] = 1;
                    play(i, j + 2, count + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static boolean browse(int y, int x) {
        int start = x;
        while (y <= n) {
            if (arr[y][x + 1] == 1) {
                x += 2;
            } else if (arr[y][x - 1] == 1) {
                x -= 2;
            }
            y++;
        }
        return start == x;
    }

    public static boolean isValid() {
        for (int i = 1; i <= m; i += 2) {
            if (!browse(1, i)) {
                return false;
            }
        }
        return true;
    }
}
