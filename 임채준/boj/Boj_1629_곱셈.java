package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1629_곱셈 {

    static long A, B, C;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    private static long pow(long a, long b, long c) {

        if(b == 0){
            return 1;
        }

        long temp = pow(a, b / 2, c);
        long result = (temp * temp) % c;

        if(b % 2 == 1){
            result = (result * a) % c;
        }

        return result;
    }
}
