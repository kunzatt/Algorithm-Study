import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1456 {

    static long A,B;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        boolean[] isPrime = new boolean[(int)Math.sqrt(B)+1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i]) continue;
            for (int j = i*2; j < isPrime.length; j+=i) {
                isPrime[j] = false;
            }
        }

        int cnt = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                long tmp=i;

                while (tmp <= (double)B/i) {
                    if (tmp >= (double)A/i) {
                        cnt++;
                    }
                    tmp *= i;
                }
            }
        }

        System.out.println(cnt);

    }
}
