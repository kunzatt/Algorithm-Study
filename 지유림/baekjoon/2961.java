import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // S: 신맛, B: 쓴맛
	// 신맛은 재료*재료, 쓴맛은 재료+재료
	static int min;
	static int[] S;
	static int[] B;
	static boolean[] visited;
	
	// 부분집합을 구해서 확인해보기 - subset
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			S[i] = s;
			B[i] = b;

			min = 1000000001;
		}

		cook(0, 1, 0);
		
		System.out.println(min);
	}
	
	static void cook(int cnt, int m, int s) {
		
		
		if(cnt == N) {
			int noCount = 0; // 재료를 하나도 쓰지 않았을 때의 값은 제외하기 위해서
			for(int i = 0; i < N; i++) {
				if(visited[i]) continue;
				noCount++;
			}
			
			if(noCount == N) return;
			min = Math.min(min, Math.abs(s-m));
			
			return;
		}
		
		visited[cnt] = true;
		cook(cnt+1, m*S[cnt], s+B[cnt]);
		visited[cnt] = false;
		cook(cnt+1, m, s);
		
		
	}
}
