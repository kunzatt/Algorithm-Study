import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R; 
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 행
		M = Integer.parseInt(st.nextToken());	// 열
		R = Integer.parseInt(st.nextToken());	// 돌리는 횟수
		
		arr = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 더 작은 값을 2로 나눠서 라인 맞추기
		rotate(Math.min(N, M) / 2);
		
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				System.out.print(arr[r][c] + " ");
			}
			
			System.out.println();
		}
		
	}
	
	static void rotate(int min) {
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < min; c++) {
				
				// 처음 시작하는 숫자를 저장해 둠!
				// 시작 위치는 항상 0,0 / 1,1 / 2,2 ... 고정됨
				int savePoint = arr[c][c];
				
				
				// 1. 오른쪽 상단 -> 왼쪽 상단
				for(int i = c+1; i < M-c; i++) {
					arr[c][i-1] = arr[c][i];
				}
				
				// 2. 오른쪽 하단 -> 오른쪽 상단
				for(int i = c+1; i < N-c; i++) {
					arr[i-1][M-c-1] = arr[i][M-c-1];
				}

				
				// 3. 왼쪽 하단 -> 오른쪽 하단
				for(int i = M-2-c; i >= c; i--) {
					arr[N-1-c][i+1] = arr[N-1-c][i];
				}
				
				// 4. 왼쪽 상단 -> 왼쪽 하단
				for(int i = N-c-2; i >= c; i--) {
					arr[i+1][c] = arr[i][c];
				}
				
				
				
				// 한칸 더 간거 끼워놓기!!
				arr[c+1][c] = savePoint;
			}
		}
		
	}
}
