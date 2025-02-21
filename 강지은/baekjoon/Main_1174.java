import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1174 {
	
	static int N;
	static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	static List<Long> list;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        
        dfs(0, 0);
        
        Collections.sort(list);
        
        if (list.size() < N) {
        	System.out.println(-1);
        } else {
        	System.out.println(list.get(N-1));
        }
        
    }

	private static void dfs(long num, int idx) {
		if (!list.contains(num)) {
			list.add(num);			
		}
		
		if (idx >= 10) return;
		
		dfs(num, idx+1);
		dfs(num*10+arr[idx], idx+1);
		
	}

	
}
