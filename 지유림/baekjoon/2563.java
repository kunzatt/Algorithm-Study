import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		// 도화지
		boolean[][] arr = new boolean[101][101];
		
		// 넓이 확인하는 값
		int cnt = 0;
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			
			// 해당 넓이 체크 안되어 있는 곳만
			for (int i = r; i < r+10; i++) {
				for (int j = c; j < c+10; j++) {
					if(arr[i][j] == false) {
						arr[i][j] = true;
						cnt++;
					}
				}
			}
		}
		
		
		
		
		System.out.println(cnt);
	}
}
