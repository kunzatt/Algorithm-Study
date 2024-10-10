import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main_20301 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken())-1;
		int M = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> deq = new LinkedList<>();
		
		for (int i = 1; i < N+1; i++) {
			deq.offer(i);
		}
		
		boolean reverse = false;
		int idx = K;
		int cnt = 0;
		while (!deq.isEmpty()) {
			
			sb.append(deq.remove(idx)+"\n");
			cnt++;
			
			if (cnt == M) {
				cnt = 0; 	
				reverse = !reverse;
			}
			
			if (deq.size() == 0) break;
			
			if (!reverse) {
				idx = (idx+K)%deq.size();				
			} else {
				for (int i = 0; i <= K; i++) {
					idx--;
					if (idx < 0)
						idx = deq.size()-1;
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
