import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10830. 행렬 제곱 / 골드4 / 1시간 20분~
// 재귀 이용, 반복문 이용 둘다 풀어보기
public class BOJ_10830 {
    static final int mod = 1_000;
    static int n;
    static long b;
    static int[][] origin;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        origin = new int[n][n];
        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
            result[i][i] = 1;
        }

        while (b > 0) {
            if (b % 2 == 1) {
                result = matrixSquare(result, origin);
            }
            origin = matrixSquare(origin, origin);
            b /= 2;
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixSquare(int[][] arr1, int[][] arr2) {
        int[][] res = new int[n][n];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    res[i][j] += (long) arr1[i][k] * arr2[k][j];
                    res[i][j] %= mod;
                }
            }
        }

        return res;
    }

}
