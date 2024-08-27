import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main_5014 {

	static int F, S, G, U, D;
	static boolean[] visit;
	static int[] count;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		int[][] stairs = new int[F+1][2];
		
		for (int i = 1; i < F+1; i++) {
			stairs[i][0] = i+U;
			stairs[i][1] = i-D;
		}
	
		visit = new boolean[F+1];
		count = new int[F+1];
		
		bfs(S, stairs);
		
	}

	private static void bfs(int start, int[][] stairs) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);
		visit[start] = true; // 방문 확인
		count[start] = 0; // 해당 층까지 도달하기 위해 움직인 횟수
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			
			if (node == G) {
				System.out.println(count[node]);
				return;
			}
			
			for (int i = 0; i < 2; i++) {
				int tmp = stairs[node][i];
				
				if (tmp <= 0 || F < tmp)
					continue;
				else if (!visit[tmp]) {
					visit[tmp] = true;
					queue.offer(tmp);
					count[tmp] = count[node]+1; // 이전 층까지 도달하기 위해 움직인 횟수+1
				}
			}
		}
		System.out.println("use the stairs");
			
	}

}
