import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int T = 10;	// 입력 수
	static int[][] bingo;
	static int[] result;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = 0;
		
		bingo = new int[5][5];	// 빙고
		result = new int[25];	// 사회자가 부르는 수
		cnt = 0; // 빙고 3개 이상인지 체크하는 로직
		
		// 5x5 개씩 나눠 받기 -> 빙고 
		for(int t = 0; t < 5; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 한 줄에 5개씩 들어옴
			for(int i = 0; i < 5; i++) {
				bingo[num][i] = Integer.parseInt(st.nextToken());
			}
			num++;
		}
		
		num = 0;
		// 5x5 = 25개 한 줄로 정답받기
		for(int t = 0; t < 5; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 5; i++) {
				result[num++] = Integer.parseInt(st.nextToken());
			}
		}
		
		

		// 받은 정답 하나에 맞춰보기~
		for(int i = 0; i < result.length; i++) {
			cnt = 0;
			for(int j = 0; j < bingo.length; j++) {
				for(int k = 0; k < bingo.length; k++) {
					if(result[i] == bingo[j][k]) {
						bingo[j][k] = -1;
						break;
					}
				}
			}
			
			// 메소드 돌면서 -1 이 5개인, -5인 것만 cnt 체크
			rowIdx();
			colIdx();
			lRdig();
			Rldig();
			
			
			if(cnt >= 3) {
				i++;
				System.out.println(i);
				break;
			}
		}

		
		
				
		
		
	}
	
	// 행 조회
	static void rowIdx() {
		int sum;
		for(int c = 0; c < bingo.length; c++) {
			sum = 0;  	
			for(int r = 0; r < bingo.length; r++) {
				sum += bingo[r][c];
			}
			
			if(sum == -5) {
				cnt++;
			} 
		}
		
		
	}
	
	// 열 조회
	static void colIdx() {
		int sum;
		for(int r = 0; r < bingo.length; r++) {
			sum = 0;
			for(int c = 0; c < bingo.length; c++) {
				sum += bingo[r][c];
			}
			
			if(sum == -5) {
				cnt++;
			}
		}
	}
	
	// 왼쪽 -> 오른쪽 아래로 대각선
	static void lRdig() {
		int sum = 0;
		for(int i = 0; i < 5; i++) { // 대각선은 5번만 보면된다~
			sum += bingo[i][i];
		}
		
		if(sum == -5) {
			cnt++;
		}
	}
	
	// 오른쪽 -> 왼쪽 아래로 대각선
	static void Rldig() {
		int r = 0;
		int c = 4;
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			sum += bingo[r++][c--];
		}
		
		if(sum == -5) {
			cnt++;
		}
	}
}
