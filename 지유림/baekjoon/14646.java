import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] menu;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        menu = new int[N+1];
        
        int count = 0;
        for(int i = 0; i < 2*N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if(++menu[idx] == 1) count++;
            else count--;
            
            result = Math.max(count, result);
        }
        
        System.out.println(result);
    }
}
