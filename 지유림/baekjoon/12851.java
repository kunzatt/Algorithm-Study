import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 갔던 위치라도 동일한 위치에 방문했다면 가능하게 해야 함 -> 다른 경우의 수가 생길 수 있으니까
// 갔던 위치에 늦은 시간에 방문했다면, 어차피 최소값 구하는건데 필요없음
// 최소값이 몇번 나왔는지 체크하는거기 때문에 visited를 boolean 이 아닌 int로 설정해
// 해당 위치의 도착시간을 담기 -> visited[3] = 2; -> 3 위치에 2만큼 시간이 걸려서 온거
public class Main12851_숨바꼭질2 {
	static int N, K;
	static int[] visited;
	static int count;
	static int min;
	static class Point {
		int n, t;

		public Point(int n, int t) {
			super();
			this.n = n;
			this.t = t;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		
		// 수빈이가 동생보다 클 때는 방법이 하나밖에 없음 -> -1밖에못해
		if(N >= K) {
			System.out.println(N-K);
			System.out.println(1);
			return;
		}
		
		visited = new int[100001];	// 최대가 10만이니까 +1
		// 방문여부 체크를 위해 int형으로
		
		
		count = 0;
		min = 100000;
		bfs();
		
		System.out.println(min);
		System.out.println(count);
	}
	
	// 처음 나온게 최소값임
	static void bfs() {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(N, 0));
		visited[N] = 1;
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			if(p.n == K) {
				// 경우의수가 0일때는 처음 나오는게 최소값임!
				if(count == 0) min = p.t;
				// 최소값으로 나왔을 때는 체크
				if(p.t == min) count++;
				continue;
			}
			
			int arr[] = {p.n+1, p.n-1, p.n*2};
			
			for(int i = 0; i < 3; i++) {
				int next = arr[i];
				
				
				if(!check(next)) continue;	// 범위체크
				
				// 방문한 적 없거나, 도착시간 같으면 다시 que에 넣어서 경우의 수를 따지기
				if(visited[next] == 0 || visited[next] == p.t+1) {
					que.offer(new Point(next, p.t+1));
					visited[next] = p.t+1;
				}
			}
		}
	}
	
	static boolean check(int num) {
		return num >= 0 && num < 100001;
	}
}
