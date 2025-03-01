import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_2668 { 

	static int N, ans;
	static HashMap<Integer, Integer> set;
	static boolean[] visit;
	static boolean flag;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        
        N = Integer.parseInt(br.readLine());
        set = new HashMap<>();
        visit = new boolean[N+1];
        
        for (int k = 1; k <= N; k++) {
        	int value = Integer.parseInt(br.readLine());
			set.put(k, value);
		}
        
        ans = 0;
        for (int i = 1; i <= N; i++) {
        	if (visit[i]) continue;
        	flag = true;
			dfs(i, i, 0);
		}
        
        System.out.println(ans);
        
        for (int i = 1; i <= N; i++) {
			if (visit[i]) {
				System.out.println(i);
			}
		}
        
    }

	private static void dfs(int start, int key, int cnt) {
		if (visit[key]) {
			if (key == start) {
				ans += cnt;
			} else {
				flag = false;
			}
			return;
		}
		
		visit[key] = true;
		dfs(start, set.get(key), cnt+1);
		if (!flag) {
			visit[key] = false;
		}
	}
    
}
