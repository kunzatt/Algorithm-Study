import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Queue<Integer> que;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        que = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            que.offer(i);
        }
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        while(!que.isEmpty()) {
            int num = que.poll();
            if(!flag) {
                sb.append(num + " ");
                flag = true;
            } else {
                que.offer(num);
                flag = false;
            }
        }
        
        System.out.println(sb);
    }
}
