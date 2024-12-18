import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int sN; // 스위치 개수
	static int[] SWITCH; // 스위치 상태 배열
	static int sC; // 학생 수
	public static void main(String[] args) throws Exception {
		// 남학생 : 1, 여학생 : 2
		// 남학생은 배수, 여학생은 좌우 살피고, 대칭 -> 그 다음 좌우로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sN = Integer.parseInt(br.readLine());
		SWITCH = new int [sN + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 스위치 개수 받아서 배열에 넣기
		for(int s = 1; s <= sN; s++) {	
			SWITCH[s] = Integer.parseInt(st.nextToken());
		}
		
		sC = Integer.parseInt(br.readLine());
		
		for(int s = 0; s < sC; s++) {
			
			st = new StringTokenizer(br.readLine());
			
			int gender = Integer.parseInt(st.nextToken());	// 성별	
			int num = Integer.parseInt(st.nextToken());		// 스위치개수
			
			
			if(gender == 1) { // 남학생인 경우
				for(int i = 1; i <= sN; i++) {
					if(i % num == 0) {	// 배수 찾기
						if(SWITCH[i] == 1) SWITCH[i] = 0;
						else SWITCH[i] = 1;
					}
				}

			} else { // 여학생인 경우
				// 왼쪽 오른쪽 확인을 위한 변수
				int left = num;
				int right = num;
				
				// left가 1 줄어들었을 때와, right + 1 했을 때의 값이 같을 때까지!
				while(left > 1 && right < sN && SWITCH[left - 1] == SWITCH[right + 1]) {
					left--;
					right++;
				}
				
				// left 부터 right 까지 변경 고고
				for(int i = left; i <= right; i++) {
					SWITCH[i] = (SWITCH[i] == 1) ? 0 : 1;
				}
			}
		}
		
		
		// 한 줄에 20개 씩 출력
		for(int i = 1; i <= sN; i++) {
			System.out.print(SWITCH[i] + " ");
			if(i % 20 == 0) System.out.println();
		}
	}
}
