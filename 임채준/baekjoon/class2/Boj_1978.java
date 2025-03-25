package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1978 {
	
	static int N, count;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		count = 0;
		
		for(int i = 0; i < N; i++) {
			
			int num = Integer.parseInt(st.nextToken());
			int temp = 0;
			
			for(int j = 1; j <= num; j++) {
				if(num % j == 0) temp++;
			}
			
			if(temp == 2) count++;
		}
		
		System.out.println(count);

	}

}
