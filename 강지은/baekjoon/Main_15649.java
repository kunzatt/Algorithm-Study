import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main_15649 {

	static int N,M;
	static List<Integer> nums = new ArrayList<>();
	static boolean[] visit;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N+1];
		
		nPr(0);
		System.out.println(sb.toString());
	}

	private static void nPr(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < nums.size(); i++) {
				sb.append(nums.get(i)+" ");
        // 한 줄에 M개씩 출력
				if ((i+1)%M==0)
					sb.append("\n");
			}
			return;
		}
		
		for (int i = 1; i < N+1; i++) {
			if (visit[i])
				continue;
			
			nums.add(i);
			visit[i] = true;
			nPr(++cnt);
			visit[i] = false;
			nums.remove(--cnt);
		}
		
	}

}
