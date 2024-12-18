import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs 연습을 위해서 풀어본 스타트링크 문제

public class Main_5014 {	// 스타트링크
	static int F, S, G;
	static int[] d = new int[2];
	static boolean[] visited;
	static int[] count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();	// 건물의 총 높이
		S = sc.nextInt(); 	// 현재 있는 층
		G = sc.nextInt();	// 스타트링크가 있는 층
		d[0] = sc.nextInt();	// 
		d[1] = sc.nextInt() * -1;
		visited = new boolean[F+1];
		count = new int[F+1];
		visited[S] = true;
		bfs(S);
		
	}

	static void bfs(int s) {
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(s);
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			if(cur == G) {
				System.out.println(count[G]);
				return;
			}
			for(int i=0; i<2; i++) {
				int ns = cur + d[i];
				if(ns > F || ns < 1) continue;
				if(visited[ns]) continue;
				que.offer(ns);
				visited[ns] = true;
				count[ns] = count[cur]+1;
				//System.out.println(ns+" "+count[ns]);
			}
//			System.out.println(que);
		}
		System.out.println("use the stairs");
	
	}
}
