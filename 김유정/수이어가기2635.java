package boj;

import java.util.Scanner;

public class 수이어가기2635 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		StringBuilder max_sb = null;
		int max = 0;
		int cnt=0;
		
		int start = sc.nextInt(); // 시작값
		for(int i = 0; i <= start; i++) {
			sb = new StringBuilder();
			int n1 = i;
			int result = start-n1; // 세번째값
			int n2 = result; // 세번째값
			cnt=2; // 첫번재, 두번째 값은 구하고 시작했으므로 
			
			sb.append(start).append(" ");
			sb.append(n1).append(" ");
			
			while(result >= 0) {
				
				sb.append(result).append(" "); // 세번째값, ...
				cnt++;
				result = n1-n2;
				n1 = n2;
				n2 = result;
				
			if(max < cnt) {
				max = cnt; // 최댓값
				max_sb = sb; // 최댓값일때의 숫자들
			}
		}
		}
		System.out.println(max);
		System.out.println(max_sb);
	
		sc.close();
	}
}
