package class3;

import java.io.*;

public class Boj_2448_별찍기11 {

    static int N;
    static char[][] stars;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stars = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                stars[i][j] = ' ';
            }
        }

        makeStars(N, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void makeStars(int n, int row, int col) {
        if (n == 3) {
            stars[row][col] = '*';
            stars[row + 1][col - 1] = '*';
            stars[row + 1][col + 1] = '*';
            for (int i = 0; i < 5; i++) {
                stars[row + 2][col - 2 + i] = '*';
            }
            return;
        }

        int half = n / 2;
        makeStars(half, row, col);
        makeStars(half, row + half, col - half);
        makeStars(half, row + half, col + half);
    }
}
