package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Boj_15686_치킨배달 {

    static int N, M, total, min, dist;
    static List<Point> house = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    house.add(new Point(i, j));
                } else if (value == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[chicken.size()];
        subset(0, 0);
        System.out.println(ans);
    }


    static void subset(int index, int count) {
        if (count > M) return;
        if (count > 0) {
            cal();
        }
        for (int i = index; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                subset(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    static void cal() {
        total = 0;
        for (Point h : house) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if (visited[i]) {
                    Point c = chicken.get(i);
                    dist = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
                    min = Math.min(min, dist);
                }
            }
            total += min;
        }
        ans = Math.min(ans, total);
    }
}
