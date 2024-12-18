import java.util.Scanner;

public class Main{
	static int N;
	static int M;
	static int[] score;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0.0;
		double avg = 0.0;
		
		N = sc.nextInt();
		
		score = new int[N];
		for(int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
			if(M < score[i]) {
				M = score[i];
			}
		}

				
		for(int i = 0; i < N; i++) {
			double aa = (double)score[i];
			avg += aa / M * 100;
			sum += avg;
		}
		
		System.out.println(avg / N);
	}
}
