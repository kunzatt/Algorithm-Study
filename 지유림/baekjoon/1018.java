import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8x8로 잘라서 생각해야함
// N = 8, M = 8 일때  경우의 수는 2 * (N-1) + (M-1)
// -7을 해서 경우의 수만큼 돌리면 될듯
public class Main{
	static int N, M;
	static int min;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		
		// 입력값 받으면서 W일때만 true
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				if(s.charAt(j) == 'W') {
					visited[i][j] = true;
				} 
			}
		}
		
		min = Integer.MAX_VALUE;
		
		// 8x8 기준
		int nn = N-7;
		int mm = M-7;
		
		for(int i = 0; i < nn; i++) {
			for(int j = 0; j < mm; j++) {
				find(i, j);
			}
		}
		
		
		
		System.out.println(min);
	}
	
	static void find(int x, int y) {
		int count = 0;
		
		// 처음 시작한 것 부터 +8을 해주면서 돌리기	-> 8만큼 해야 그전까지 돌릴 수 있음
		// +7을 하고 <= 해도 됨
		int ex = x+8;
		int ey = y+8;
		
		boolean b = visited[x][y]; 
		
		for(int i = x; i < ex; i++) {
			for(int j = y; j < ey; j++) {
			
				// 같은 색이 아니면  count 증가
				if(visited[i][j] != b) {
					count++;
				}
				
				// 다음 칸은 색깔이 바뀌니까......
				b = (!b);	// 바꿔주기
			}
			// 다음줄로 넘어왔으면 색 바꿔주야함
			b = !b;
		}
		
		// 첫번째 칸을 기준 -> 색칠 한 개수
		// 첫번째 칸의 반대색 기준 -> 개수 
		// 두개 비교해서 더 작은거를 count에 담기 
		count = Math.min(count, 64-count);
		min = Math.min(min, count);	// 최소값 찾기
	}
	
	
	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
