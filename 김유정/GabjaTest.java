//package com.ssafy.ws.step4;
package Day_0722;

import java.util.Scanner;

/**
 * 60 갑자를 서양력으로 변환하는 프로그램
 */

public class GabjaTest {
	static char[] sibgan = {'갑', '을', '병', '정', '무', '기', '경', '신', '임', '계'};
	static char[] sibiji = {'자', '축', '인', '묘', '진', '사', '오', '미', '신', '유', '술', '해'};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String year;
		
		while(true) {
			
	    	year = sc.next();
	    	if(year.equals("종료")) {
	    		break;
	    	}
    		int sibgan_idx = 0;
	    	int sibiji_idx = 0;
	    	
	    
	    	for(int i = 0; i<sibgan.length; i++) {
	    		if (year.charAt(0) == sibgan[i]) {
	    			sibgan_idx = i;
	    			break;
	    		}
	    	}
	    	for(int i = 0; i<sibgan.length; i++) {
	    		if (year.charAt(1) == sibiji[i]) {
	    			sibiji_idx = i;
	    			break;
	    		}
	    	}

	    	for(int i = 1444; i<=2100; i++) {
	    		if((  (i-1444)%10 == sibgan_idx  ) && (  (i-1444)%12 == sibiji_idx  )) { 
	    			if (i >= 1800) {
	    				System.out.print(i + " ");
	    			}
	    			
	    		}
	    		
	    	}
	    		

	    	
		} 
    	sc.close();
	}
}
    	
    	
    	
    

