import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N == 1) System.out.println(1);
        else if(N == 2) System.out.println(Math.min(4, (M+1)/2));
        else if(N >= 3) {
            if(M < 7) {
                System.out.println(Math.min(4, M));
            } else {
                System.out.println(M-2);
            }
        }
    }
}
