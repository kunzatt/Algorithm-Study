import java.util.Scanner;

public class Solution_1209 {
	static 	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		for(int t=1; t<=10; t++) {
			int tc = sc.nextInt();
			int max = findMax();
			
			System.out.printf("#%d %d\n", tc, max);
		}
		
	}
	
	public static int findMax() {
		int[][] arr = new int[100][100];
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 행의 합
		for (int i = 0; i < arr.length; i++) {
			int rtotal = 0;
			int ctotal =0;
			int total =0;
			for (int j = 0; j < arr.length; j++) {
				rtotal += arr[i][j];
				ctotal += arr[j][i];
				total = Math.max(ctotal, rtotal);
			}
			max = Math.max(max, total);
			//System.out.printf("%d total: %d\n", i, rtotal);
			//System.out.printf("%d total: %d\n", i, ctotal);
		}
		
		// 대각선 합
		int dtotal=0;
		int dtotal1 = 0, dtotal2=0;
		for (int i = 0; i < arr.length; i++) {
			dtotal1 += arr[i][i];
			dtotal2 += arr[i][arr.length-i-1];
		}
		dtotal = Math.max(dtotal1, dtotal2);
		//System.out.println(dtotal1);
		//System.out.println(dtotal2);
		max = Math.max(max, dtotal);
		
		//System.out.println(max);
		return max;
	}
	
}
