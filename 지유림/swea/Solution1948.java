import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1948_날짜계산기 {
	static int T;
	static int m1, d1;
	static int m2, d2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			m1 = Integer.parseInt(st.nextToken());
			d1 = Integer.parseInt(st.nextToken());
			m2 = Integer.parseInt(st.nextToken());
			d2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			if(m1 == m2) {
				sum = d2 - d1 + 1; 
			} else {
				while(m1 < m2) {

					if(m1 < 8) {
						if(m1 == 2) {
							sum += 28;
						} else if(m1 % 2 == 0) {
							sum += 30;
						} else {
							sum += 31;
						}
					} else if(m1 >= 8) {
						if(m1 % 2 == 0) {
							sum += 31;
						} else {
							sum += 30;
						}
					}
					m1++;
				}
				
				sum = sum + d2 - d1 + 1;
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}
