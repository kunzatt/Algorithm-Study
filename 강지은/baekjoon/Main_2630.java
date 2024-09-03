import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630 {

	static int N;
	static int[][] map;
	static int wcnt;
	static int bcnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		wcnt = 0;
		bcnt = 0;
		divided(0, 0, N);
		
		System.out.println(wcnt);
		System.out.println(bcnt);
		
	}

	private static void divided(int r, int c, int n) {
		
		boolean check = true;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[r][c] != map[r+i][c+j]) {
					check = false;
					break;
				}
			}
		}
		
		if (check) {
			if (map[r][c] == 0)
				wcnt++;
			else
				bcnt++;
		} else {
			divided(r, c, n/2);
			divided(r+n/2, c, n/2);
			divided(r, c+n/2, n/2);
			divided(r+n/2, c+n/2, n/2);
		}
		
		
		
	}

}
