import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2048 {
	
	static int T;
	static int l,r, ans;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			if (r-l == 1 && l < 3) {
				ans = r+1;
			} else if (r-l == 3 && l == 0 ) {
				ans = r+2;
			} else {
				ans = r;
			}
			
			System.out.println(ans);
		}		
	}
}
