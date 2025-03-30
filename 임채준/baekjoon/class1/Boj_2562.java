package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2562 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		int max = 0;
		int idx = 0;
		
		for(int i = 1; i < 10; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp > max) {
				max = temp;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}

}
