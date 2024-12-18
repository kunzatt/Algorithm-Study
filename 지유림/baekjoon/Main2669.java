import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int fx, fy, lx, ly;
	static int T = 4;
	static int N = 100;
	static int[][] square = new int[N][N];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// fx, fy : first x, first y 첫번째 좌표들
			// lx, ly : last x, last y 마지막 좌표들
			fx = Integer.parseInt(st.nextToken());
			fy = Integer.parseInt(st.nextToken());
			lx = Integer.parseInt(st.nextToken());
			ly = Integer.parseInt(st.nextToken());
			
			// 첫번째 좌표부터 시작해서 마지막 좌표까지 1을 넣어줌
			// 1을 넣으면서 중복값 제거도 같이!!
			for(int r = fx; r < lx; r++) {
				for(int c = fy; c < ly; c++) {
					square[r][c] = 1;
				}
			}
			
			cnt = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					cnt += square[r][c];
				}
			}
		}
		
		
		System.out.println(cnt);
	}
}
