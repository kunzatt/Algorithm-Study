package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 빙고2578 {
	static int[] map;
	static int[] call;
	static int N = 5;
	static boolean bingo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N*N];
		call = new int[N*N];
		for(int i = 0; i < N; i++) { // 내 빙고
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[5*i+j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) { // 사회자 호출
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				call[5*i+j] = Integer.parseInt(st.nextToken());
			}
		}

		// 연산
		for(int j = 0; j < call.length; j++) {
			for(int i = 0; i < map.length; i++) {
				if(map[i] == call[j]) { // 만약 사회자 호출 == 내 빙고이면, 0으로 바꾸기
					map[i] = 0;
					bingo = check(map); // 빙고인지 체크
					break;
				}
			}
			if(bingo) { // 만약 빙고를 완성했다면
				System.out.println(j+1);
				break;
			}
		}
		
	}

	// 빙고 체크 로직
	// 1차원 배열로 받았기 때문의 별도의 수식으로 로직 체크
	static boolean check(int[] map) {
		int cnt;
		int bingo = 0;
		// 가로 체크
		for(int i = 0; i < N; i++) {
			cnt = 0;
			for(int j = 0; j < N; j++) {
				if(map[5*i+j] == 0) cnt++; 
				if(cnt == 5) bingo++;
			}
		}

		// 세로 체크
		for(int i = 0; i < N; i++) {
			cnt = 0;
			for(int j = 0; j < N; j++) {
				if(map[i+5*j] == 0) cnt++;
				if(cnt == 5) bingo++;
			}
		}

		// 대각선 체크, 좌상단 -> 우하단
		cnt = 0;
		for(int i = 0; i < N; i++) {
			if(map[6*i] == 0) {
				cnt++;
			}else {
				break;
			}
			if(cnt == 5) bingo++;
		}
		// 우상단 -> 좌하단
		cnt = 0;
		for(int i = 0; i < N; i++) {
			if(map[(i+1)*4] == 0) {
				cnt++;
			}else {
				break;
			}
			if(cnt == 5) bingo++;
		}

		// 만약 빙고수 3이상이면 
		if(bingo >= 3) return true;
		return false; // 3미만이면
	}
}
