import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		String a = br.readLine();
		String b[] = a.split(" ");
		
		int min = Integer.parseInt(b[0]);
		int max = Integer.parseInt(b[0]);
		
		for(int i = 0; i < b.length; i++) {
			int c = Integer.parseInt(b[i]);
			
			if(min > c) {
				min = c;
			} else if(max < c) {
				max = c;
			}
		}
		
		bw.write(String.valueOf(min) + " " + String.valueOf(max));

		bw.flush();
		bw.close();
	}
}
