import java.io.*;
import java.util.*;

public class Softeer_Xmarksthespot {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            String[] tarr = st.nextToken().split("");

            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == 'x' || S.charAt(j) == 'X') {
                    sb.append(tarr[j].toUpperCase());
                }
            }
        }

        System.out.println(sb);
    }
}