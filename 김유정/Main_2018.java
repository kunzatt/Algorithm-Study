package java0804;

import java.util.Scanner;

public class Main_2018 {
    
    static int N;
    static int sum;
    static int cnt;
	
    public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = 0;
        
		for(int i = 1; i <= N; i++) {
			sum = 0;
			int j = i;
			while(true) {
				if(sum > N) {
					break;
				}else if(sum == N) {
					cnt++;
					break;
				}
				sum += j;
				j++;
			}
		}
		System.out.println(cnt);

	}

}
