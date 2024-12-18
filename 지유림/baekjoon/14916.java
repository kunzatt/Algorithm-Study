import java.util.Scanner;

public class Main {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int num = (N % 5) % 2;
		
		if(N < 5 && N % 2 != 0) {
			System.out.println(-1);
		} else if(num != 0) {
			int a = (N / 5) - 1;
			int b = N - (a * 5);
			int result = (b / 2) + a;
			System.out.println(result);
		} else if(num == 0){
			System.out.println((N / 5) + (N % 5) / 2);
		}
	}
}
