import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1238_Contact {
	static int T = 10;
	static int N, S;
	static int[][] number;
	static int[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken()); // 시작번호
			
			// 100 이하 랬으니까 걍 배열...
			number = new int[101][101];
			visited = new int[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N/2; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				// 유향그래프
				number[s][e] = 1;
			}
			
			
			sb.append("#").append(t).append(" ").append(bfs(S)).append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	static int bfs(int idx) {
		
		Queue<Integer> que = new LinkedList<>();
		que.add(idx);
		int max = 1;
		visited[idx] = max;
		
		while(!que.isEmpty()) {
			int p = que.poll();
			
			for(int i = 0; i < 101; i++) {
				if(visited[i] == 0 && number[p][i] == 1) {
					visited[i] = visited[p]+1;
					que.offer(i);
				}
			}
			
			max = Math.max(max, visited[p]);
		}
		
		
		for(int i = 100; i >= 0; i--) {
			if(visited[i] == max) 
				return i;
		}
		
		return -1;
	}
}
