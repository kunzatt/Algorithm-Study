import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int S;
	static int Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] mArr = new int[7];
		int[] fArr = new int[7];
		
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			if(S == 1) {
				mArr[Y]++;
			} else {
				fArr[Y]++;
			}
		}
		
		
		int cnt = 0;
		for(int i = 1; i < mArr.length; i++) {
			if(mArr[i] % K == 0 && mArr[i] != 0) {
				cnt += mArr[i] / K;
			} else if(mArr[i] % K != 0 && mArr[i] != 0){
				cnt += (mArr[i] / K) + 1;
			}
		}
		
		for(int i = 1; i < fArr.length; i++) {
			if(fArr[i] % K == 0 && fArr[i] != 0) {
				cnt += fArr[i] / K;
			} else if(fArr[i] % K != 0 && fArr[i] != 0) {
				cnt += (fArr[i] / K) + 1;
			}
			
		}
		
		System.out.println(cnt);
		
	}
}
