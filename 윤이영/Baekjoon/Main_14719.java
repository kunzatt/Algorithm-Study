import java.util.Scanner;

public class Main_14719 {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int[][] arr = new int[H][W];
		
		for(int i=0; i<W; i++) {
			int tmp = sc.nextInt();
			for(int h=H-tmp; h<H; h++) {
				arr[h][i] = 2;
			}
		}
		

		int total=0;
		int cnt=0;
		for (int r = 0; r < H; r++) {
			
			for (int c = 0; c < W; c++) {
				cnt=0;
				if(arr[r][c] == 2) {
					for(int d = 1; d<W-c; d++) {
						if(arr[r][c+d]==2) {
							total += d-1;
							break;
						}

					}
					
				}

			}

		}
		
		System.out.println(total);
	}
	
	
}

