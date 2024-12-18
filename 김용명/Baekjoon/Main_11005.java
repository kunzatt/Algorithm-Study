import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11005 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		
		while (r > 0) {
			if(r%n >= 10) {
				sb.append((char) ((r%n) + 55));
			}
			if(r%n < 10) {
				sb.append(r%n);
			}
			r = r/n;
		}
		for (int i = sb.length()-1; i >= 0; i--) {
			System.out.print(sb.charAt(i));
		}		
	}
}
