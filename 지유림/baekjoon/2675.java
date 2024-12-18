
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			int r = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			for(int j = 0; j < s.length(); j++) {
				for(int k = 0; k < r; k++) {
					System.out.print(s.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
