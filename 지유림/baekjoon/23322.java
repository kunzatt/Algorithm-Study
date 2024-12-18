import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main23322_초콜릿뺏어먹기 {
	static int N, K;
	static int[] chocolates;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		chocolates = new int[N];
		for(int i = 0; i < N; i++) {
			chocolates[i] = Integer.parseInt(st.nextToken());
		}
		
		// 초콜릿 개수를 오름차순 정렬
        Arrays.sort(chocolates);
		
		int chocoCount = 0;
		int days = 0;
		
		for(int i = 1; i < N; i++) {
			// 현재 초콜릿 개수가 이전 초콜릿 개수와 같거나 크고, 가장 작은 초콜릿 개수보다 크면..
			if(chocolates[i] > chocolates[i-1] && chocolates[i] > chocolates[0]) {
				while(chocolates[i] > chocolates[i-1]) {
					chocolates[i]--;
					chocoCount++;
				}
				
				days++;
			}
		}
		System.out.println(chocoCount + " " + days);
		
		
	}
}
