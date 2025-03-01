import java.io.*;
import java.util.*;

public class Main1158_요세푸스문제 {
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            que.offer(i);
        }

        sb.append("<");
        int count = 0;
        boolean flag = false;
        while(!que.isEmpty()) {
            count++;
            int num = que.poll();

            if(count == K) {
                count = 0;
                if(!flag) {
                    sb.append(num);
                    flag = true;
                } else if(flag) {
                    sb.append(", " + num);
                }

                continue;
            }
            que.offer(num);
        }

        sb.append(">");
        System.out.println(sb.toString());
    }
}
