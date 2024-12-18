import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int[] visited;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1][N+1];
		visited = new int[N+1];
		count = 0;
		
		dfs(1);
		System.out.println(count);
	}
	
	static void dfs(int cnt) {
		if(cnt == N+1) {
			count++;
			return;
		}
		
		for(int i = 1; i < N+1; i++) {
			if(visited[i] != 0) continue;
			if(!check(cnt, i)) continue;
			
			visited[i] = cnt;
			dfs(cnt+1);
			visited[i] = 0;
		}
		
		
	}
	
	static boolean check(int r, int c) {
		for(int i = 1; i < N+1; i++) {
			if(visited[i] == 0) continue;
			int rr = visited[i];
			int cc = i;
			
			// 동일한게 있으면 false
			if(r+c == rr+cc || r-c+N+1 == rr-cc+N+1) {
				return false;
			}
		}
		
		// 없다
		return true;
	}
}
