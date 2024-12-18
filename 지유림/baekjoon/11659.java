import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 누적합 배열
		int[] sumArr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		// 누적합으로 배열 받기
		for(int i = 1; i <= N; i++) {
			sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// sumArr 1부터 받았기 때문에 -1 해줌!
			long result = sumArr[end] - sumArr[start - 1];
			
			bw.write(String.valueOf(result) + "\n");
		}
	
		bw.flush();
		bw.close();
	}
}
