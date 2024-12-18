import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3985 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());	//롤케이크 길이
		int N = Integer.parseInt(br.readLine());	// 방척객 수
		
		int[] arr = new int[L+1];
		int[] count = new int[N+1];
		int guess = 0;
		int guessidx =0;

		for(int t=1; t<=N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if(guess < K-P) {	// 가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호 찾기
				guess = K-P;
				guessidx = t;
			}
			for(int i=P; i<=K; i++) {	// 롤케이크 분배
				if(arr[i] != 0)	
					continue;	// 이미 나눠줬으면 패스
				else {
					arr[i] = t;
					count[t]++;
				}		
			}
		}
		
		System.out.println(guessidx);
		// 가장 많은 조각을 받은 방청객 찾기
		int maxc = 0;
		int maxp = 0;
		for(int i=1; i<=N; i++) {
			if(maxc < count[i]) {
				maxc = count[i];
				maxp = i;
			}
		}
		System.out.println(maxp);
	}

}
