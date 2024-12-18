package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[] dir = {'^', 'v', '<', '>'};
    static int n, m, d;
    static char[][] arr;
    static char[] controls;
    static int curY = 0, curX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = s.charAt(j);
                    if (s.charAt(j) == '<') {
                        curY = i;
                        curX = j;
                        d = 2;
                    } else if (s.charAt(j) == '>') {
                        curY = i;
                        curX = j;
                        d = 3;
                    } else if (s.charAt(j) == '^') {
                        curY = i;
                        curX = j;
                        d = 0;
                    } else if (s.charAt(j) == 'v') {
                        curY = i;
                        curX = j;
                        d = 1;
                    }
                }
            }
            int o = Integer.parseInt(br.readLine());
            controls = br.readLine().toCharArray();
            play();
            arr[curY][curX] = dir[d];
            System.out.print("#" + t + " ");
            for (int i = 0; i < n; i++) {
                System.out.println(String.copyValueOf(arr[i]));
            }
        }
    }

    public static void play() {
        arr[curY][curX] = '.';
        for (int i = 0; i < controls.length; i++) {
            if (controls[i] == 'U') {
                d = 0;
                int ny = curY + dy[d];
                int nx = curX + dx[d];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] == '.') {
                    curY = ny;
                    curX = nx;
                }
            } else if (controls[i] == 'D') {
                int ny;
                int nx;
                d = 1;
                ny = curY + dy[d];
                nx = curX + dx[d];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] == '.') {
                    curY = ny;
                    curX = nx;
                }
            } else if (controls[i] == 'L') {
                int ny;
                int nx;
                d = 2;
                ny = curY + dy[d];
                nx = curX + dx[d];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] == '.') {
                    curY = ny;
                    curX = nx;
                }
            } else if (controls[i] == 'R') {
                int ny;
                int nx;
                d = 3;
                ny = curY + dy[d];
                nx = curX + dx[d];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] == '.') {
                    curY = ny;
                    curX = nx;
                }
            } else if (controls[i] == 'S') {
                int ny;
                int nx;
                ny = curY;
                nx = curX;
                while (true) {
                    ny += dy[d];
                    nx += dx[d];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] == '*') {
                        arr[ny][nx] = '.';
                        break;
                    }
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || arr[ny][nx] == '#') {
                        break;
                    }
                }
            }
        }
    }
}
