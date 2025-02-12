import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_중위순회 {
	static int N;
	static char[] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			N = Integer.parseInt(br.readLine());
			sb.append("#"+t+" ");
			tree = new char[N+1];
			for(int i=1; i<=N; i++) {
				tree[i] = br.readLine().split(" ")[1].charAt(0);
			}
			dfs(1);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int cur) {
		if(cur > N) return;
		dfs(cur*2);	//왼쪽 자식을 재귀 호출
		sb.append(tree[cur]);	// 현재 노드의 값을 처리
		dfs(cur*2+1);	// 오른쪽 자식을 재귀 호출
		
	}
}
