import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477 {
	
	static int[][] arr = new int[6][2];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int xmax = 0;
		int ymax = 0;
		int xmax_idx = 0;
		int ymax_idx = 0;
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		for (int i = 0; i < 6; i++) {
			if(arr[i][0] == 1 || arr[i][0] == 2) {
				if(xmax < arr[i][1]) {
					xmax = arr[i][1];
					xmax_idx = i;
				}
			}
			else if(arr[i][0] == 3 || arr[i][0] == 4) {
				if(ymax < arr[i][1]) {
					ymax = arr[i][1];
					ymax_idx = i;
				}
			}
		}
		
		// x나 y의 max 값 전,후 인덱스에는 max값과 빼야하는 값이 나올 수 밖에 없다.
		int xans = Math.abs(arr[(xmax_idx+5)%6][1]-arr[(xmax_idx+1)%6][1]); 
		int yans = Math.abs(arr[(ymax_idx+5)%6][1]-arr[(ymax_idx+1)%6][1]);
		
		int barea = xmax*ymax;	
		int sarea = xans*yans;
		System.out.println((barea-sarea)*K);
	}	
}
