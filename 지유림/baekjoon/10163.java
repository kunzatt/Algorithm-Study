import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M = 1001;
	static int[][] arr = new int[M][M];
	static int[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int j = r; j < r + w; j++) {
				for(int k = c; k < c + h; k++) {
					arr[j][k] = i;
				}
			}
		}
		

		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				result[arr[i][j]]++;
			}
		}
	
		for(int i = 1; i <= N; i++) {
			System.out.println(result[i]);
		}
	}
}
