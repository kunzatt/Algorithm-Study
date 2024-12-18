import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1966_숫자를정렬하자 {
	static int T;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			int[] num = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			// 버블정렬
			for(int i = 0; i < N-1; i++) {
				for(int j = 0; j < N-1; j++) {
					if(num[j] > num[j+1]) {
						int temp = num[j];
						num[j] = num[j+1];
						num[j+1] = temp;
					}
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			
		}
	}
}
