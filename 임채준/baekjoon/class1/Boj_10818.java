package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10818 {
	
	static int N, max, min, temp;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		max = -1000001;
		min = 1000001;
		for(int i = 0; i < N; i++) {
			temp = Integer.parseInt(st.nextToken());
			if(temp > max) max = temp;
			if(temp < min) min = temp;
		}
		System.out.println(min + " " + max);

	}

}
