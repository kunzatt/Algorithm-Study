import java.io.*;
import java.util.*;

public class Main_2225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[][] = new int[K][N + 1];
        Arrays.fill(arr[0], 1);

        for (int i = 1; i < K; i++) {
            arr[i][0] = 1;
            for (int j = 1; j <= N; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i][j - 1])%1000000000;
            }
        }
        System.out.println(arr[K - 1][N]%1000000000);
    }
}