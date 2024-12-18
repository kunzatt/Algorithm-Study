import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main10164_격자상의경로 {
	static int N, M, K;
	static int[][] map;
	static int[][] drc = {{0, 1}, {1, 0}};
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		K = Integer.parseInt(st.nextToken());
		result = 0;
		
		// K가 0이 아닐 때 도착지점 구하기
		int pr = 0; 
		int pc = 0; 
		
		
		// K가 0이 아니면 0에서 K까지의 경우의수 * K에서 목적기까지 경우의 수
		if(K != 0) {
			int num = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = num++;
					
					if(map[i][j] == K) {
						pr = i;
						pc = j;
					}
				}
			}
		
			int point1 = 1;
			int point2 = 1;
			
			
			dfs(0, 0, pr, pc);
			point1 = result;
			result = 0;
			dfs(pr, pc, N-1, M-1);
			point2 = result;
			
			System.out.println(point1*point2);
			
		} else {
			result = 0;
			dfs(0, 0, N-1, M-1);
			System.out.println(result);
		}
		
		
	
	}
	
	static void dfs(int r, int c, int pr, int pc) {
		if(r == pr && c == pc) {
			result++;	// 도착하면 하나증가
			return; 
		}
		
		// 크면 범위 벗어났다 !
		if(r > pr || c > pc) {
			return;
		}
		
		dfs(r+1, c, pr, pc);	// 밑으로 한 칸
		dfs(r, c+1, pr, pc); 	// 오른쪽으로 한 칸
	}
	
	
}
