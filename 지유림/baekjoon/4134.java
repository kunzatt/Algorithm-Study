import java.io.*;
import java.util.*;

class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());

            long result = num;
            while (true) {
                if (isPrime(result)) break;
                result++;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
