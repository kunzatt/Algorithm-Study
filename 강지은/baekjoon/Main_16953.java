import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953 {
	
	static int A, B;
	static long cnt;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		long ans = bfs(A);
		System.out.println(ans);
	}

	private static long bfs(int a) {
		Queue<long[]> queue = new LinkedList<>();
		queue.offer(new long[] {a, 0});
		
		while (!queue.isEmpty()) {
			long[] cur = queue.poll();
			long num = cur[0];
			long cnt = cur[1];

			if (num == B) return cnt+1;
			
			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					if (num*2 > B) continue;
					queue.offer(new long[] {num*2, cnt+1});
				} else {
					if (num*10+1 > B) continue;
					queue.offer(new long[] {num*10+1, cnt+1});
				}
			
			}
		}
		
		return -1;
	}
	
}
