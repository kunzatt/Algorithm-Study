import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234 {
	static int T, N;
	static int[] arr;
	static boolean[] visited;
	static int[] left;
	static int[] right;
	static int ans;
	static int leftsum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			left = new int[N];
			right = new int[N];
			visited = new boolean[N];
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			perm(0, 0);
			
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
	private static void perm(int cnt, int idx) {
		if(cnt == N) {
			// System.out.println(N-1-idx);
			//System.out.println(Arrays.toString(left));
			// 왼쪽 오른쪽 계산
			leftsum = 0;
			calRight(0, leftsum, 0);
			return;
		}
		
		
		for(int i=0;i<N; i++) {
			if(visited[i]) continue;
			
			left[cnt] = arr[i];
			if(cnt == 0) {
				idx = i;
			}
			visited[i] = true;
			perm(cnt+1, idx);
			visited[i] = false;
		}
	}

	private static void calRight(int start, int leftsum, int rightsum) {
		if(start == N) {
			if(leftsum >= rightsum) {
				ans++;
				//System.out.println("right"+ Arrays.toString(right) + " / " + ans);
			}
			
			
			return;
		};
		if(rightsum > leftsum) {
			return;
		}
		calRight(start+1, leftsum+left[start], rightsum);	//  오른쪽 무게추에 선택을 안한 경우

		right[start] = left[start];
		calRight(start+1, leftsum, rightsum+left[start]);	// 오른쪽 무게추에 추가한 경우
		right[start] = 0;
	}
}