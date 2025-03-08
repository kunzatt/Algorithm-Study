import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int T, K;
    static PriorityQueue<Long> pq;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            for(int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long result = 0;
            long sum = 0;

            while(true) {
                long a = pq.poll();
                long b = pq.poll();

                sum = a + b;

                result += sum;

                if(pq.isEmpty()) break;

                pq.offer(sum);
            }
            sb.append(result + "\n");
        }

        System.out.println(sb.toString());
    }

}
