import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
	
	static int N, K;
	static int Max = 100001;
	static int[] op;
	static int cnt;
	static List<Integer> visit;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		op = new int[] {-1, 1, N};
		visit = new ArrayList<>();
		
		for (int i = 0; i < Max; i++) {
			visit.add(0);
		}

		
		bfs();
		System.out.println(cnt);

	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visit.set(N, 1);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			op[2] = x;
			
			for (int i = 0; i < op.length; i++) {
				int num = x + op[i];
				
				if (!(0<=num && num < Max)) continue;
				if (visit.get(num) > 0) continue;
				if (num == K) {
					cnt = visit.get(x);
					return;
				}
				queue.offer(num);
				visit.set(num, visit.get(x)+1);
			}
			
		}
	}

}
