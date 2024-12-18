import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int h1, m1;
	static int h2, m2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sumS = 0;
			int sumM = 0;
			
			
			h1 = Integer.parseInt(st.nextToken());
			m1 = Integer.parseInt(st.nextToken());
			
			h2 = Integer.parseInt(st.nextToken());
			m2 = Integer.parseInt(st.nextToken());
			
			sumS = h1 + h2;
			sumM = m1 + m2;
			
			if(sumM > 60) {
				sumM -= 60;
				sumS += 1;
			}
			
			if(sumS > 12) {
				sumS -= 12;
			}
			
			System.out.println("#" + t + " " + sumS + " " + sumM);
			
		}
	}
}
