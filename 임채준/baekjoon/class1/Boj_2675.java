package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2675 {
	
	static int T, N, len;
	static String word;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			word = st.nextToken();
			StringBuilder sb = new StringBuilder();
			len = word.length();
			for(int i = 0; i < len; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(word.charAt(i));
                }
            }
			System.out.println(sb);
		}

	}

}
