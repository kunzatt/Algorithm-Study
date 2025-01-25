import java.io.*;
import java.util.*;

public class Main11501_주식 {
    static int T, N;
    static long result;
    static int[] num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            result = 0L;
            num = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            int max = num[N-1]; // 마지막 값을 가장 큰 값으로 임의로 두기

            for(int i = N-2; i >= 0; i--) {
                if(num[i] <= max) { // 가장 큰 시세보다 작은 시세일 때 판매하기
                    result += max - num[i];
                } else {
                    max = num[i];
                }
            }

            sb.append(result + "\n");
        }

        System.out.println(sb.toString());
    }
}
