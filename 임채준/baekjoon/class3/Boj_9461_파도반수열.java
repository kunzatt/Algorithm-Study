package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_9461_파도반수열 {
	
	static int T, N;
	static long[] P;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        P = new long[101];
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;

        for (int i = 6; i <= 100; i++) {
            P[i] = P[i-2] + P[i-3];
        }

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(P[N]);
        }
    }
}