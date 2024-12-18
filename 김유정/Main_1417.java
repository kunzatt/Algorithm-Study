package algol0805;

import java.util.Scanner;

public class Main_1417 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 후보의 수
		int[] candi = new int[N+1]; // 각 후보를 찍으려는 사람의 수
		int maxIdx = 0;
		int max;
		int cnt = 0;
		
		// 입력
		for(int i = 1; i <=N; i++) {
			candi[i] = sc.nextInt();
		}
		boolean check = true;
		
		while(check) {
			if(N == 1) {
				System.out.println(cnt);
				break;
			}
			
			// max값 탐색
			max = 0;
			for(int i = 2; i <= N; i++) {
				if(candi[i] > max) {
					max = candi[i];
					maxIdx = i;
				}
			}
			
			// 후보 한명 매수
			if(max < candi[1]) {
				System.out.println(cnt);
				break;
			} else {
				candi[1]++;
				candi[maxIdx]--;
				cnt++;
			}
		}
		sc.close();	
	}
}
