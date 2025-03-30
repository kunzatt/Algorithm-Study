package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2884 {
	
	static int h, m, ah, am;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		if(m - 45 < 0 && h == 0) {
			ah = 23;
			am = 60 + m - 45;
		} else if(m - 45 < 0) {
			ah = h - 1;
			am = 60 + m - 45;
		} else {
			ah = h;
			am = m - 45;
		}
		System.out.println(ah + " " + am);

	}

}
