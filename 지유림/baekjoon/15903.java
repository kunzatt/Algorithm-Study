import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static PriorityQueue<Long> pq;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        int count = 0;
        while(true) {
            if(count == M) break;

            long a = pq.poll();
            long b = pq.poll();

            for(int i = 0; i < 2; i++) {
                pq.offer(a+b);
            }
            count++;
        }

        long result = 0;
        while(!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);
        
    }
}
