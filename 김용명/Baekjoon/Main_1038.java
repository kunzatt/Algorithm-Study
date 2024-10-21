import java.io.*;
import java.util.*;

// 수학적 사고를 조금 해야하는 문제

public class Main_1038 {

    static int N;
    static ArrayList<Long> list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if (N >= 1023) System.out.println(-1);
        else {

            for (int i = 0; i < 10; i++) {
                dfs(i);
            }

            Collections.sort(list);
            System.out.println(list.get(N));
        }

    }

    static void dfs(long num) {
        list.add(num);
        long a = num % 10;

        if(a == 0) {
            return;
        }

        for(long i = a - 1; i >= 0; i--) {
            long n = num * 10 + i;
            dfs(n);
        }
    }
} 