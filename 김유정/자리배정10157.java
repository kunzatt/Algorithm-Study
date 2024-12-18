package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// 달팽이와 유사한 문제
public class 자리배정10157 {
	static int R, C; // 가로, 세로
	static int wait; // 대기고객
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0}; // 위 오 아래 왼
	static int[] dc = {0, 1, 0, -1}; // 위 오 아래 왼
	static boolean isPossible = false;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt(); // 가로
		R = sc.nextInt(); // 세로
		map = new int[R][C]; // 공연장
		wait = sc.nextInt(); // 대기고객 순서
//		System.out.println(C + " " + R);
		int num = 1;
		int c = 0; // 세로
		int r = R-1; // 가로
		int d = 0; // 위로
		while(num-1 <= R*C) {
			if(num-1 == wait) { // 만약 중간 숫자를 발견한다면
				isPossible = true;
				break;
			}else if(num-2 == R*C) { // 마지막 숫자와 일치한다면
				isPossible = true;
				break;
			}
			System.out.println(num);
			map[r][c] = num++;
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 방향 바꾸기
			if(d==0) {
				if(check(nr, nc)) d = 1;
			}else if(d == 1) {
				if(check(nr, nc)) d = 2;
			}else if(d == 2) {
				if(check(nr, nc)) d = 3;
			}else {
				if(check(nr, nc)) d = 0;
			}
			r = r + dr[d];
			c = c + dc[d];
		}
//		for(int i = 0; i < R; i++) { // 중간 수치를 확인하기 위한 코드
//			System.out.println(Arrays.toString(map[i]));
//		}

		if(isPossible) { // 값을 찾으면 델타만큼값을 빼준다 (49번라인)
			System.out.println((c-dc[d]+1) + " " + (R-(r-dr[d])));
		}else {
			System.out.println(0); // 못찾으면
		}
		
	}

	private static boolean check(int r, int c) {
		if(r>=0 && r<R && c>=0 && c<C && map[r][c] == 0)
			return false;
		return true;
	}
}
