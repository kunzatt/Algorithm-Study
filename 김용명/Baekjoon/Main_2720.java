import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] changes = {25, 10, 5, 1};
		int[] arr = new int[4];
		
		for (int i = 0; i < t; i++) {
			int total = Integer.parseInt(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[j] = total/changes[j];
				total = total%changes[j];
					
			}
			for (int k = 0; k < 4; k++) {
				System.out.print(arr[k] + " ");	
			}
			System.out.println();
		}
		
	}
}
