import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11660 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][n+1];
		
		// 누적합 배열 계산
		for (int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= n; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken()) + arr[r-1][c] + arr[r][c-1]- arr[r-1][c-1];
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken()); // 입력값 4개
			
			int sum = arr[x2][y2] - (arr[x1-1][y2] + arr[x2][y1-1] - arr[x1-1][y1-1]); // 슬라이스 윈도우
			
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
	}

}
