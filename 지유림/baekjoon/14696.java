import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] aArr;
	static int[] bArr;
	static char[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result = new char[N];
		
		for(int t = 0; t < N; t++) {
			aArr = new int[5];
			bArr = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			for(int i = 0; i < a; i++) {
				int aa = Integer.parseInt(st.nextToken());
				aArr[aa]++;
			}
			
			for(int i = 0; i < b; i++) {
				int bb = Integer.parseInt(st2.nextToken());
				bArr[bb]++;
			}

			
			for(int i = 4; i > 0; i--) {
				int num = aArr[i] - bArr[i];
				
				if(num > 0) {
					result[t] = 'A';
					break;
				} else if(num < 0) {
					result[t] = 'B';
					break;
				} else if(num == 0 && i == 1) {
					result[t] = 'D';
					break;
				} else if(num == 0) {
					continue;
				} 
			}
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	
	}
}
