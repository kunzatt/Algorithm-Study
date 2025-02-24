import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13975 {
    static int T, K;
    static int[] file;
    static long ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        // 테스트케이스
        for(int tc=1; tc<=T; tc++){
            K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                int n = Integer.parseInt(st.nextToken());
                pq.add((long) n);
            }
            ans = 0;
            while(pq.size()>1){
                long c = pq.poll()+pq.poll();
                pq.add(c);
                ans += c;
            }
            //ans += pq.poll();
            System.out.println(ans);
        }
    }
}
