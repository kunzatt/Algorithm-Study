import java.io.*;
import java.util.*;

public class Main1110_더하기사이클 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int count = 0;
        int result = N;

        do {
            String str = result < 10 ? "0" + result : String.valueOf(result);

            // 각 자리수 더하기
            int sum = Character.getNumericValue(str.charAt(0)) +
                    Character.getNumericValue(str.charAt(1));

            // 원래 수의 오른쪽 자리 + 합의 오른쪽 자리
            result = (Character.getNumericValue(str.charAt(1)) * 10 +
                    (sum % 10));
            count++;
        } while(result != N);

        System.out.println(count);
    }
}
