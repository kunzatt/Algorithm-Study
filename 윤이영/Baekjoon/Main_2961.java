import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961 {
	static int N;
	static int[] sour;
	static int[] bitter;
	static int pick;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0, 0, 1, 0);
		System.out.println(min);
		
	}
	
	static void subset(int cnt, int pick, int ssum, int bsum) {
		if(cnt == N ) {
			if(pick > 0) {
				min = Math.min(min, Math.abs(ssum-bsum));
			}
			return;
		}
		// 재료를 선택했을 경우:
		subset(cnt+1, pick+1, ssum*sour[cnt], bsum+bitter[cnt]);
		// 재료를 선택하지 않았을 경우:
		subset(cnt+1, pick, ssum, bsum);
	}

}
