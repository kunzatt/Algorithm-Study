import java.io.*;
import java.util.*;

public class Main_1806 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int ans = Integer.MAX_VALUE;
		int sum = 0, s = 0, e = 0;
		
		while (true) {
			if (sum >= M) {
				sum -= list.get(s);
				ans = Math.min(ans, e - s);
				s++;
			} else if (e == N) {
				break;
			} else {
				sum += list.get(e++);
			}
		}
		
		System.out.println(ans==Integer.MAX_VALUE? 0 : ans);

	}

}
