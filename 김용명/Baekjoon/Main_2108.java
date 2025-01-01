import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2108 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		double sum = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		int count = 0;
		int max = -1;
		int mod = arr[0];
		boolean check = false;
		
		for(int i = 0; i < N - 1; i++) {
			if(arr[i] == arr[i + 1]) {
				count++;
			}else {
				count = 0;
			}
			
			if(max < count) {
				max = count;
				mod = arr[i];
				check = true;
			}else if(max == count && check == true) {
				mod = arr[i];
				check = false;
			}
		}
		sb.append(Math.round(sum/N)).append("\n").append(arr[(N-1)/2]).append("\n").append(mod).append("\n").append(arr[N-1]-arr[0]);
		System.out.println(sb);
		
	}

}
