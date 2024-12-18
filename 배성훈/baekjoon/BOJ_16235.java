import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 16235. 나무 재테크 / 골드3 / 2시간 21분
public class BOJ_16235 {
    public static class Tree implements Comparable<Tree> {
        int y, x, age;

        public Tree(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    static final int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static final int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};

    static int[][] currentFood;
    static int[][] add;
    static PriorityQueue<Tree>[][] arr;
    static Queue<Tree> deadTree;

    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        currentFood = new int[n][n];
        add = new int[n][n];
        arr = new PriorityQueue[n][n];
        deadTree = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(currentFood[i], 5);
            for (int j = 0; j < n; j++) {
                add[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = new PriorityQueue<>();
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            Tree t = new Tree(y, x, age);
            arr[y][x].add(t);
        }
        while (k-- > 0) {
            spring();
            summer();
            fall();
            winter();
        }
        int ans = countTree();
        System.out.println(ans);
    }

    // 봄에 나무가 자기칸의 양분을 먹는다
    // 자기 나이만큼 못먹으면 죽는다
    // 죽은 나무는 여름에 양분을 나누는 과정으로 간다
    // 우선순위큐로 조회만 하고 중복객체가 조회되는걸 방지하기 위해 새로운 리스트에 삽입하는 형식으로 하자.
    public static void spring() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Tree> aliveTree = new ArrayList<>();
                while (!arr[i][j].isEmpty()) {
                    Tree t = arr[i][j].poll();
                    if (currentFood[i][j] >= t.age) {
                        currentFood[i][j] -= t.age;
                        t.age++;
                        aliveTree.add(t);
                    } else {
                        deadTree.add(t);
                    }
                }
                arr[i][j].addAll(aliveTree);
            }
        }
    }

    // 죽은 나무의 양분을 그 칸에 나눈다
    public static void summer() {
        while (!deadTree.isEmpty()) {
            Tree t = deadTree.poll();
            int y = t.y;
            int x = t.x;
            currentFood[y][x] += t.age / 2;
        }
    }

    // 가을에는 번식함
    // 5의 배수 나이를 가진 나무만
    // 8방으로 나이가 1인 나무가 생김
    // 범위 벗어나면 나무안생김
    public static void fall() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Tree> tList = new ArrayList<>(arr[i][j]);
                for (Tree t : tList) {
                    if (t.age % 5 == 0) {
                        int y = t.y;
                        int x = t.x;
                        for (int l = 0; l < 8; l++) {
                            int ny = y + dy[l];
                            int nx = x + dx[l];
                            if (ny >= 0 && nx >= 0 && ny < n && nx < n) {
                                arr[ny][nx].add(new Tree(ny, nx, 1));
                            }
                        }
                    }
                }
            }
        }
    }

    // 현재 양분에 add 배열 값 다 더하기
    public static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                currentFood[i][j] += add[i][j];
            }
        }
    }

    // 살아있는 나무의 개수 센다
    public static int countTree() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += arr[i][j].size();
            }
        }
        return count;
    }

}
