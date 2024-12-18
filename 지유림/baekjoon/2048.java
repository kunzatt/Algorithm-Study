import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, l, r;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		

		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();	
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			int count = 0;
			if(r >= 4) count = r;
			else {
				for(int i = l; i <= r; i++) {
					sb.append((int)(Math.pow(2, i)));
				}
				
				int result = Integer.parseInt(sb.toString().trim());
				while(result % 2 == 0) {
					result /= 2;
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
	
}
