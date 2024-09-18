import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1011 {
	
	static int T;
	static int x, y;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			int dist = y-x;
			int n = (int)Math.sqrt(dist);

			int ans = 0;

      // 수학 규칙으로 찾기...
			if (n*n == dist)
				ans = 2*n-1;
			else if (n*n < dist && dist <= n*n+n)
				ans = 2*n;
			else
				ans = 2*n+1;
			
			System.out.println(ans);
			
		}
		
	}
	
}
