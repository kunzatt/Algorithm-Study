import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] basket;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		basket = new int[N + 1];
		for(int i = 1; i < basket.length; i++) {
			basket[i] = i;
		}
		
		for(int k = 0; k < M; k++) {
			 int i = sc.nextInt();
			 int j = sc.nextInt();
			 
			 while(i < j) {
				 int temp = basket[i];
				 basket[i++] = basket[j];
				 basket[j--] = temp;
			 }
		}
		
		for(int i = 1; i < N + 1; i++) {
			System.out.print(basket[i] + " ");
		}
	}
}
