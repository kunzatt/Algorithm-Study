import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 17143. 낚시왕 / 골드1 / 1시간43분
// 상어 이동 시 좌표 압축 필요.
public class BOJ_17143 {
    static class Shark implements Comparable<Shark> {
        int y, x, speed, dir, size;

        Shark(int y, int x, int speed, int dir, int size) {
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

        @Override
        public int compareTo(Shark o) {
            return o.size - this.size;
        }
    }

    static final int[] dy = {0, -1, 1, 0, 0};
    static final int[] dx = {0, 0, 0, 1, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, s;
    static Shark[][] arr;
    static PriorityQueue<Shark> sharks;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new Shark[n + 1][m + 1];
        sharks = new PriorityQueue<>();
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            if (dir == 1 || dir == 2) {
                speed %= (2 * (n - 1));
            } else {
                speed %= (2 * (m - 1));
            }
            arr[y][x] = new Shark(y, x, speed, dir, size);
            sharks.add(arr[y][x]);
        }
        int start = 0;
        int count = 0;
        while (start < m) {
            start++;
            count += take(start);
            move();
        }
        System.out.println(count);
    }

    private static int take(int col) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i][col] != null) {
                res = arr[i][col].size;
                arr[i][col] = null;
                break;
            }
        }
        return res;
    }

    private static void move() {
        List<Shark> list = new ArrayList<>();
        Shark[][] temp = new Shark[n + 1][m + 1];
        while(!sharks.isEmpty()) {
            Shark shark = sharks.poll();
            if (arr[shark.y][shark.x] == null) {
                continue;
            }
            arr[shark.y][shark.x] = null;
            int speed = shark.speed;
//            System.out.println("이동 전:"+shark.y+","+shark.x+" 방향:"+shark.dir);
            while (speed-- > 0) {
                int ny = shark.y + dy[shark.dir];
                int nx = shark.x + dx[shark.dir];
                if (ny < 1 || nx < 1 || ny > n || nx > m) {
                    if (shark.dir == 1 || shark.dir == 3) {
                        shark.dir++;
                    } else {
                        shark.dir--;
                    }
                    ny = shark.y + dy[shark.dir];
                    nx = shark.x + dx[shark.dir];
                }
                shark.y = ny;
                shark.x = nx;
            }
//            System.out.println("이동 후:"+shark.y+","+shark.x+" 방향:"+shark.dir);
            // 잡아먹혔어야 할 상어가 아직 남아있다..
            if (temp[shark.y][shark.x] == null) {
                temp[shark.y][shark.x] = shark;
                list.add(shark);
            }
        }
        sharks.addAll(list);
        for (int i = 1; i <= n; i++) {
            arr[i] = temp[i].clone();
        }
    }
}
