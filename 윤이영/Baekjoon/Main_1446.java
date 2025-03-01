import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1446 {
    static int N, D;
    static int[] dp;
    static PriorityQueue<Pos> pq = new PriorityQueue<>();
    static class Pos implements Comparable<Pos> {
        int start, end, dist;
        public Pos (int start, int end, int dist){
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pos o){
            return Integer.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dp = new int[D+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int strt = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if(end <= D){
                pq.add(new Pos(strt, end, dist));
            }
        }

        // DP 초기화
        for(int i=1; i<=D; i++){
            dp[i] = i;
        }

        // DP + Priority Queue
        while(!pq.isEmpty()) {
            Pos cur = pq.poll();
            if(dp[cur.start] + cur.dist < dp[cur.end]){
                dp[cur.end] = dp[cur.start] + cur.dist;

                // 지름길 이용 후의 구간도 재설정
                for(int i= cur.end+1; i<=D; i++){
                    dp[i] = Math.min(dp[i], dp[i-1]+1);
                }
            }
        }

        System.out.println(dp[D]);
    }
}
