import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] basket;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		basket = new int[N];
		
		for(int i = 0; i < basket.length; i++) {
			basket[i] = i + 1;
		}
		
		for(int idx = 0; idx < M; idx++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			int temp = basket[i - 1];
			basket[i - 1] = basket[j - 1];
			basket[j - 1] = temp;
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(basket[i] + " ");
		}
	}
}
