// [백준] 색종이 - 1
import java.util.Scanner;

public class Main_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[100][100];
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int r=0; r<10; r++) {
				for (int c = 0; c < 10; c++) {
					arr[x+r][y+c] = 1; 
				}
			}
		}
		
		int cnt =0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
