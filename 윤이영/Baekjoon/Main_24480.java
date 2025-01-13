import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_24480 {
	static int N, M, R;
	static ArrayList<Integer>[] list;
	static int[] visited;
	static int order = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		list = new ArrayList[N+1];
		visited = new int[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(list[i], Collections.reverseOrder());
		}
		
		dfs(R);
		
		for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
	}

	private static void dfs(int node) {
		visited[node] = order++;
		
		for(int next: list[node]) {
			if(visited[next] == 0) {
				dfs(next);
			}
		}
		
	}
}
