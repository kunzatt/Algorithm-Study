import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main_13335 {

	static int n;
	static int w;
	static int L;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			queue.add(0);
		}
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		int[] trucks = new int[n];
		for (int i = 0; i < n; i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		int num = 0;
		while (num <= n) {
			
			if (num == n) {
				time += queue.size();
				break;
			}
			
			sum -= queue.poll();
			if (sum+trucks[num] <= L) {
				sum += trucks[num];
				queue.offer(trucks[num++]);
			} else {
				queue.offer(0);
			}
			
			time++;
		}
		
		System.out.println(time);
		
	}

}
