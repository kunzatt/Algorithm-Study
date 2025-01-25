import java.io.*;
import java.util.*;

public class Main1541_잃어버린괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // '-'를 기준으로 분리
        StringTokenizer minus = new StringTokenizer(str, "-");

        // 첫 번째 그룹의 합 계산
        int result = calculateSum(minus.nextToken());

        // 나머지 그룹들의 합을 뺌
        while(minus.hasMoreTokens()) {
            result -= calculateSum(minus.nextToken());
        }

        System.out.println(result);
    }

    // 문자열에 포함된 모든 수의 합을 계산하는 함수
    static int calculateSum(String str) {
        int sum = 0;
        StringTokenizer plus = new StringTokenizer(str, "+");
        while(plus.hasMoreTokens()) {
            sum += Integer.parseInt(plus.nextToken());
        }
        return sum;
    }
}
