import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1068 {
	
	static int N, K;
	static List<Integer>[] tree;
	static boolean[] visit;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N];
		
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		int root = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if (p == -1) root = i;
			else tree[p].add(i);
		}
		
		K = Integer.parseInt(br.readLine());
		
		cnt = 0;
		if (K != root) dfs(root);
		
		System.out.println(cnt);
		
	}

	private static void dfs(int root) {
		visit[root] = true;
		boolean isLeaf = true; // 리프 확인

		for (int next : tree[root]) {
			if (next == K) continue;
			if (visit[next]) continue;
			isLeaf = false;
			dfs(next);
		}

		if (isLeaf) cnt++;
	}

}
