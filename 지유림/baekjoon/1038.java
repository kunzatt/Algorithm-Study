import java.io.*;
import java.util.*;

public class Main1038_감소하는수 {
    static List<Long> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        // 1부터 9까지의 한 자리 수를 시작으로 감소하는 수를 만든다
        for(int i = 0; i <= 9; i++) {
            dfs(i);
        }

        // 정렬
        Collections.sort(list);

        // N번째 감소하는 수 출력
        if(N >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
    }

    static void dfs(long num) {
        list.add(num);

        // 마지막 자릿수
        long lastDigit = num % 10;

        // 마지막 자릿수보다 작은 수를 붙여서 새로운 감소하는 수를 만든다
        for(long i = 0; i < lastDigit; i++) {
            dfs(num * 10 + i);
        }
    }
}
