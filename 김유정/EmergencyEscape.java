package com.ssafy.ws.step5;

import java.util.Scanner;

public class EmergencyEscape {

    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] v = new int[N]; // 속도
		int[] h = new int[N]; // 고도
//		int v_agv = 0;
//		int h_avg = 0;
		int time = 0;
		
		for(int i = 0; i < N; i++) {
			v[i] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) {
			h[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			
			
			if(i>=2) { // 2분간의 고도변화
				if(h[i-2]-h[i] >= 2000 && ((double)(v[i-1] + v[i-2]))/2 >= 1100) {
					
						time = i;
						break;
					
				}
			}
			if(i>=3) { // 3분간의 고도변화
				if(h[i-3]-h[i] >= 3000 && ((double)(v[i-1] + v[i-2]+v[i-3]))/3 >= 1000) {
						time = i;
						break;
					
				}
			}
			if(i>=4) { //4분간의 고도변화
				if(h[i-4]-h[i] >= 4000 && ((double)(v[i-1] + v[i-2]+v[i-3]+v[i-4]))/4 >= 900) {
						time = i;
						break;
					
				}
			}
			
		}
		
		if (time == 0) {
			System.out.println(-1);
		}else {
			System.out.println(time+1);
		}
		
		sc.close();
    }

}
