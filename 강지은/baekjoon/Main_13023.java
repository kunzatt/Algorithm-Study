import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13023 {
    
	static int N, M;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;
	static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());	
        
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
        
        flag = false;
        for (int i = 0; i < N; i++) {
        	visit = new boolean[N];
        	visit[i] = true;
			friend(i, 1);
			
			if (flag) {
				System.out.println(1);
				return;
			}
		}
        
        System.out.println(0);
    }

	private static void friend(int idx, int depth) {
		if (depth==5) {
			flag = true;
			return;
		}
		
		for (int i = 0; i < adj[idx].size(); i++) {
			int next = adj[idx].get(i);
			if (visit[next]) continue;
						
			visit[next] = true;
			friend(next, depth+1);
			visit[next] = false;
		}
		
	}
    
}
