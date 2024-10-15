import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_26070 {
    
	static long[] gom, ticket;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		gom = new long[3];
		ticket = new long[3];
		
		// 곰곰이 수
		for (int i = 0; i < 3; i++) {
			gom[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		// 식권 수
		for (int i = 0; i < 3; i++) {
			ticket[i] = Integer.parseInt(st.nextToken());
		}
		
		long count = 0;
		
		while (true) {
			boolean flag = false;
			
			for (int i = 0; i < 3; i++) {
				
				count += Math.min(ticket[i], gom[i]);
				
				if (ticket[i] >= gom[i]) {
					ticket[i] -= gom[i];
					gom[i] = 0;
				} else {
					gom[i] -= ticket[i];
					ticket[i] = 0;				
				}
				
				if (ticket[i] >= 3) {
					if (i==2) {
						ticket[0] += ticket[i]/3;
						ticket[i] %= 3;
					} else {
						ticket[i+1] += ticket[i]/3;
						ticket[i] %= 3;	
					}		
				}
			}
			
			for (int i = 0; i < 3; i++) {
				if (ticket[i] >= 3) flag=true;
			}
			
			if (!flag) break;			
		}
	  
		count += Math.min(ticket[0], gom[0]);
		
		System.out.println(count);
		
	}
}
