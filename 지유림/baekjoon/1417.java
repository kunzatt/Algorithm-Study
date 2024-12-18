import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		// 우선순위 큐 : Collections.reverseOrder()를 사용하지 않으면 작은수가 튀어나옴
		// 큰 숫자가 튀어나오게~
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int t = 0; t < N - 1; t++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int cnt = 0;
		while(!(pq.isEmpty()) && pq.peek() >= M) {
			cnt++;
			M++;
			pq.add(pq.poll() - 1);
		}
		
		System.out.println(cnt);
	}
}
