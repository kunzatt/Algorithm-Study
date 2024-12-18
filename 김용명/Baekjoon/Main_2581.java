import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2581 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N-M+1];
		int num = M;
		int count = 0;
		int sum = 0;
		int min = 10001;
		
		for (int i = 0; i < N-M+1; i++) {
			arr[i] = num++;
		}
		for (int i = 0; i < N-M+1; i++) {
			if(isPrimeNumber(arr[i])) {
				count++;
				sum += arr[i];
				if(min > arr[i]) {
					min = arr[i];
				}
			}
		}
		if(count == 0) {
			System.out.println(-1);
		}else {
			System.out.printf("%d\n"+"%d", sum, min);
		}	
	}
	
	static boolean isPrimeNumber(int a) {
		if(a == 1) return false;
		for (int j = 2; j < a; j++) {
			if(a%j == 0) return false;
		}		
		return true;
	}	
}