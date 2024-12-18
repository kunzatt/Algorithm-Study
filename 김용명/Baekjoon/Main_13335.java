import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// SWEA 피자 문제와 비슷 
public class Main_13335 {
	
	static Queue<Integer> bridge;
	static Queue<Integer> wait;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		bridge = new LinkedList<>();
		wait = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			wait.offer(Integer.parseInt(st.nextToken()));
		}
		
		int count = 0; 
		int sum = 0;
		
		// bridge 큐에 0을 넣어줘서 트럭이 이동하는 시간을 구한다.
		for(int i = 0; i < w; i++) {
			bridge.offer(0);
		}
		
		while(!bridge.isEmpty()) {
			count++;
			sum -= bridge.poll();
			if(!wait.isEmpty()) {
				if(wait.peek() + sum <= L) {
					sum += wait.peek();
					bridge.offer(wait.poll());
				}else {
					bridge.offer(0);
				}
			}
		}
		System.out.println(count);
	}
}