import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851 {
	
	static int N, K;
	static int Max = 100001;
	static int[] op;
	static int time, cnt;
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
		
		if (N==K)
			System.out.println(0+"\n"+1);
		else {
			time = Max;
			bfs();
			System.out.println(time+"\n"+cnt);
		}

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
				
				if (time < visit.get(x)) continue;
				if (!(0<=num && num < Max)) continue;
				if (num == K) {
					time = Math.min(visit.get(x), time);
					cnt++;
				}
				if (visit.get(num)==0 || visit.get(num)==visit.get(x)+1) {
					queue.offer(num);
					visit.set(num, visit.get(x)+1);
				}
			}
			
		}
	}

}
