import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정렬 후에 가장 큰 값 + 가장 작은 값 더해나가면서 최대값 구하기
public class Main20300_서강근육맨 {
    static int N;
    static long[] m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        m = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            m[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(m);

        long max = 0L;
        int num = 0;
        if(N % 2 != 0) {
           num = 1;
        }

        for(int i = 0; i < N-num; i++) {
            max = Math.max(max, m[i]+m[N-1-num-i]);
        }

        System.out.println(max);
    }
}
