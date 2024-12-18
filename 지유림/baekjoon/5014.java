import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS 문제같음..ㅠㅠ 뭔지 몰라서 BFS 검색해서 응용해보았습니다
// 방문했던 층은 체크하면서, UP / DOWN 다 돌면서 확인해봐야 함
public class Main {
	static int F, S, G, U, D;
	static boolean[] visited;	// 방문여부를 확인하는 것
	static int[] move; // 움직인 횟수 체크
	static int result; // 결과값
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());	// 빌딩 총 층수
		S = Integer.parseInt(st.nextToken());	// 강호의 현재 층
		G = Integer.parseInt(st.nextToken());	// 스타트링크의 층 수
		U = Integer.parseInt(st.nextToken());	// U의 개수
		D = Integer.parseInt(st.nextToken());	// D의 개수 
		
		
		// 방문여부를 확인해야함
		visited = new boolean[F + 1];
		move = new int[F + 1];
		
		
		// 간단한건 거르게
		boolean flag = true;

		if(S > G && D != 0 && S - G % D == 0 || S > G && D == 0) {
			flag = false;
		}
		
		
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(S);
		
		
		visited[S] = true; // 처음 시작층은 방문 했으니까 true
		
		
		boolean flag2 = bfs(queue);
		
		
		
		
		if(!flag || !flag2) System.out.println("use the stairs");
		else System.out.println(move[result]);
	}
	
	static boolean bfs(Queue<Integer> queue) {
		
		while(!queue.isEmpty()) {
			int flow = queue.poll();

			if(flow == G) {
				result = flow;
				return true;
			}
			
			
			if(flow + U <= F && !visited[flow + U] && flow + U > 1) {
				visited[flow+U] = true;
				queue.add(flow+U);
				move[flow+U] = move[flow]+1;
			}

			if(flow - D >= 1 && !visited[flow - D] && flow - D > 0) {

				queue.add(flow-D);
				visited[flow-D] = true;
				move[flow-D] = move[flow]+1;
			}
			
		}
		
		return false;
	}
	
	
	/*
	 * cnt가 아닌 배열로 횟수를 확인하는 이유:
	 * cnt로 하게 되면 up, down 할 때 모두 체크가 됨..
	 * 한번에 Up, Down을 같이하게 되는 경우를 1번으로 체크해야 하기 때문에 배열을 쓰는 거 같다 -> 이거 잘 ㅗㅁ르겠음
	 * */
}
