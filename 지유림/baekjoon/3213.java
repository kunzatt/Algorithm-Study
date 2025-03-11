import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] pizza;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pizza = new int[3];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();

            if(str.equals("1/4")) pizza[0]++;
            else if(str.equals("1/2")) pizza[1]++;
            else pizza[2]++;
        }

        int result = 0;

        // 3/4
        result += pizza[2];
        pizza[0] = Math.max(0, pizza[0] - pizza[2]);

        result += (pizza[1] + 1) / 2;

        pizza[0] = Math.max(0, pizza[0] - (pizza[1] % 2) * 2);
        result += (pizza[0] + 3) / 4;

        System.out.println(result);
        

    }
}
