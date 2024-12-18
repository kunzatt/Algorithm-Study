import java.util.Scanner;

public class Main_2567{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[102][102];
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int r=0; r<10; r++) {
				for (int c = 0; c < 10; c++) {
					arr[x+r+1][y+c+1] = 1; 
				}
			}
		}
		
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

		int cnt =0;
		for (int r = 1; r <=100 ; r++) {
			for (int c = 1; c <=100; c++) {
                // 4방 확인;
                int check = 0;
                if(arr[r][c] == 1){
                    for(int d = 0; d<4; d++){
                        int nr = r+dr[d];
                        int nc = c+dc[d];
                        if(arr[nr][nc] == 1){
                            check++;
                        }
                    }
                }
                if(check == 2){
                    cnt+=2;
                }
                else if(check==3){
                    cnt++;
                }
			}
		}
		
		System.out.println(cnt);
	}
}