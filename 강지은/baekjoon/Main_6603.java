import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603 {

	static int k;
	static int[] nums;
	static boolean[] visit;
	static int[] result = new int[6];
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			if (k == 0) return;
			
			nums = new int[k];
			visit = new boolean[k];
			for (int i = 0; i < k; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			
			lotto(0, 0);
			System.out.println();
		}
		
	}

	private static void lotto(int start, int cnt) {
		if (cnt == 6) {
			sb = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				sb.append(result[i]+" ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		for (int i = start; i < k; i++) {
			if (visit[i]) continue;
			result[cnt] = nums[i];
			visit[i] = true;
			lotto(i, cnt+1);
			visit[i] = false;
			result[cnt] = 0;
		}
		
	}

}
