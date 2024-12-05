import java.io.*;
import java.util.*;

public class Main_1759 {
	
	static int L, C, count;
	static String[] p, nums;
	static String[] vowels = {"a", "e", "i", "o", "u"};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		p = new String[C];
		nums = new String[L];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < C; i++) {
			p[i] = st.nextToken();
		}
		
		Arrays.sort(p);
		dfs(0, 0);

	}
	static void dfs(int cnt, int idx) {
		
		if (cnt == L) {
			count = 0;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < 5; j++) {
					if (nums[i].equals(vowels[j])) count++;
				}
			}
			if (count >= 1 && L-count >= 2) {
				for (int i = 0; i < L; i++) {
					System.out.print(nums[i]);
				}
				System.out.println();
			}
			return;
		}
		
		for (int i = idx; i < C; i++) {
			nums[cnt] = p[i];
			dfs(cnt+1, i+1);
		}
		
	}

}
