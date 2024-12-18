import java.util.Scanner;

public class Main {
	static int T;
	static int[] arr = {1, 1, 2, 2, 2, 8};
	static int[] result = new int[6];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 6; i++) {
			T = sc.nextInt();
			result[i] = arr[i] - T;
		}
		
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}
