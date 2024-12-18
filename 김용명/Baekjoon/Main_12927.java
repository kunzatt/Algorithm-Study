import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12927 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] arr = new int[str.length()+1];
		int cnt = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'Y') {
				arr[i+1] = 1;
			}
		}
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] == 1) {
				cnt++;
				for (int j = 1; j <= (arr.length-1)/i; j++) {
					if(arr[i*j] == 1) {
						arr[i*j] = 0;
					}else {
						arr[i*j] = 1;
					}
				}
			}
		}
		System.out.println(cnt);

	}

}
