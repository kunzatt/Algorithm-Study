import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N = 9;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		boolean stop = false;
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		sum -= 100;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr.length - 1; j++) {
				if(arr[i] + arr[j] == sum) {
					arr[i] = 0;
					arr[j] = 0;
					stop = true;
					break;
				}
			}
			
			if(stop) break;
		}
		
		Arrays.sort(arr);
		for(int i = 2; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
	}
}
