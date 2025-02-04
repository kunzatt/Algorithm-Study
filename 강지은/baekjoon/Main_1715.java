import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715 { 

	static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(br.readLine());
			pq.add(card);
		}
        
        int ans = 0;
        while (pq.size() > 1) {
        	int A = pq.poll();
        	int B = pq.poll();
        	
        	ans += (A+B);
        	pq.add(A+B);
        	
        }
        
        System.out.println(ans);
        
    }
    
}
