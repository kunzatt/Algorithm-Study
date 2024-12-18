import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1110 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int temp = n;
		int count = 0;
		
		
		while(true) {
			int a = n/10;
			int b = n%10;
			n = (b*10)+((a+b)%10);
			count ++;
			if(temp == n) {
				break;
			} 
		}
		System.out.println(count);

	}

}