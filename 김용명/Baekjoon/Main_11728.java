import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] farr = new int[N];
        int[] sarr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            farr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sarr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0, j = 0;

        while (i < N && j < M) {
            if (farr[i] <= sarr[j]) {
                sb.append(farr[i++]).append(" ");
            } else {
                sb.append(sarr[j++]).append(" ");
            }
        }

        while (i < N) {
            sb.append(farr[i++]).append(" ");
        }

        while (j < M) {
            sb.append(sarr[j++]).append(" ");
        }

        System.out.println(sb);
    }
}