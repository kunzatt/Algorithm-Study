import java.util.Arrays;
import java.util.Scanner;

public class Main_9076 {
	static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {    	
    	int t = sc.nextInt();
    	for(int i=0; i<t; i++) {
    		scoreSystem();
    	}
    }
    
    public static void scoreSystem() {
    	int[] score = new int[5];
    	int total=0;
    	
    	for (int i = 0; i < score.length; i++) {
			score[i] = sc.nextInt();
		}
    	
    	Arrays.sort(score);
    	
    	if(score[3] - score[1] >= 4 ) {
    		System.out.println("KIN");
    	} 
    	else {
    		for(int i=1; i<4; i++) {
    			total+= score[i];
    		}
    		System.out.println(total);
    	}

    }
   
}