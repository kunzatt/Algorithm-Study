import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16437 {
	static int N;
	static ArrayList<Integer>[] tree;
	static int[] sheep;
	static long[] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		sheep = new int[N+1];
		result = new long[N+1];
		for(int i=0; i<=N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=2; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if(s.equals("S")) {
				// 양이 살고 있는 경우
				sheep[i] = a;
			}else {
				// 늑대가 살고 있는 경우 
				sheep[i] = a * -1;
			}
			
			tree[p].add(i);	// 부모 리스트에 자식 추가 (다리)
		}
		
		long ans = dfs(1);
		System.out.println(ans);
	
	}

	
	private static long dfs(int s) {
		long sum = 0;
		
		// 후위 순회 - 리프노드까지 이동
		for(int child : tree[s]) {
			// 현재 노드의 모든 자식을 방문
			sum += dfs(child);
		}
		
		sum += sheep[s];
		// 1번 섬으로 가는 길에 늑대가 더 많으면, 양들은 모두 갈 수 없다
		result[s] = Math.max(0, sum);
		
		return result[s];
	}
}
