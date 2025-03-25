package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1654_랜선자르기 {
	
	static int K, N, maxlength;
	static int[] lines;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		lines = new int[K];
		maxlength = 0;
		for(int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			maxlength = Math.max(maxlength, lines[i]);
		}
		
		long start = 1;
		long end = maxlength;
		long result = 0;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			long count = cal(lines, mid);
			if(count >= N) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(result);
	}

	private static long cal(int[] lines, long length) {
		long count = 0;
		for(int line : lines) {
			count += line / length;
		}
		return count;
	}

}
