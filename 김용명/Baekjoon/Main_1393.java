import java.util.*;
import java.io.*;

public class Main_1393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int xs = Integer.parseInt(st.nextToken());
        int ys = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int xe = Integer.parseInt(st.nextToken());
        int ye = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());

        int ax = xe, ay = ye;
        double minDist = distance(xe, ye, xs, ys);

        if (dx == 0 && dy == 0) {
            System.out.println(ax + " " + ay);
            return;
        }

        double t = ((xs - xe) * dx + (ys - ye) * dy) / (double)(dx * dx + dy * dy);

        if (t <= 0) {
            System.out.println(ax + " " + ay);
            return;
        }

        int x1 = (int)Math.floor(xe + t * dx);
        int y1 = (int)Math.floor(ye + t * dy);
        int x2 = (int)Math.ceil(xe + t * dx);
        int y2 = (int)Math.ceil(ye + t * dy);

        int[][] arr = {
                {x1, y1}, {x1, y2}, {x2, y1}, {x2, y2}
        };

        for (int[] point : arr) {
            int x = point[0];
            int y = point[1];

            boolean flag = false;
            if (dx == 0) {
                flag = (x == xe);
            } else if (dy == 0) {
                flag = (y == ye);
            } else {
                flag = Math.abs((y - ye) * dx - (x - xe) * dy) < 1e-9;
            }

            if (flag) {
                double dist = distance(x, y, xs, ys);
                if (dist < minDist) {
                    minDist = dist;
                    ax = x;
                    ay = y;
                }
            }
        }

        for (int i = -100; i <= 100; i++) {
            for (int j = -100; j <= 100; j++) {
                if (isLine(xe, ye, dx, dy, i, j)) {
                    double dist = distance(i, j, xs, ys);
                    if (dist < minDist) {
                        minDist = dist;
                        ax = i;
                        ay = j;
                    }
                }
            }
        }

        System.out.println(ax + " " + ay);
    }

    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    private static boolean isLine(int xe, int ye, int dx, int dy, int x, int y) {
        if (dx == 0) {
            return x == xe && ((y - ye) % dy == 0);
        }
        if (dy == 0) {
            return y == ye && ((x - xe) % dx == 0);
        }

        if ((x - xe) % dx != 0) return false;
        if ((y - ye) % dy != 0) return false;

        int tx = (x - xe) / dx;
        int ty = (y - ye) / dy;

        return tx == ty && tx >= 0;
    }
}