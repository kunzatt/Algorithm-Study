import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477 {	// 백준-참외밭
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[2][6];
		int rmax = 0;
		int cmax = 0;
		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[0][i] = Integer.parseInt(st.nextToken());
			map[1][i] = Integer.parseInt(st.nextToken());
			if(map[0][i] == 1 || map[0][i] == 2) {	// 동, 서
				cmax = Math.max(cmax, map[1][i]);
			}
			else {	// 남, 북
				rmax = Math.max(rmax, map[1][i]);
			}
		}
		
		int sub = 0;	// 큰 사각형에서 뺴야할 면적 구하기
		int i=0;
		while(true) {
			int j=i+1;	
			if(map[0][i%6] == map[0][(i+2)%6] && map[0][j%6]== map[0][(j+2)%6]) {	// 방향이 반복되는 경우 -> 중간 부분이 빼야할 작은 사각형
				sub = map[1][(i+2)%6] * map[1][j%6]; 	
				break;
			}
			i++;
		}
		int cnt = ((rmax*cmax)-sub)*K;	// 참외 계산
		System.out.println(cnt);
	}

}
