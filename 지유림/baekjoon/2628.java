import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken()); // 가로의 값인데, 세로로 받음
		int r = Integer.parseInt(st.nextToken()); // 세로의 값인데, 가로로 받음
		
		
		boolean[][] square = new boolean[r+1][c+1];

		int N = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			
			int slice = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if(slice == 0) { // 가로일때, 세로좌표 num기준으로 가로를 다 자름
				for(int i = 0; i < c; i++) {
					square[num][i] = true;
				}
			} else { // 세로일때, 가로 좌표 num기준으로 세로를 다 자름
				for(int i = 0; i < r; i++) {
					square[i][num] = true;
				}
			}
		}

    // 엄청난 변수들..ㄷㄷ
		int rNum = 0;
		int cNum = 0;
		int max = -1;
		int clen = 0;
		int rlen = 0;
		int nowR = 0;
		int pastR = 0;
		boolean flag = false;
		while(true) {
			
			if(flag) break;

      // 처음에 가로 기준으로, 세로로 자른 숫자가 몇인지 찾아보기
			for(int i = cNum; i <= c; i++) {
				if(square[0][i] == true || i == c) {
					pastR = nowR;
					nowR = i;
					clen = Math.abs(pastR - nowR);
					cNum = ++i;
					flag = false;
					break;
				}
			}
			
			
			
			
			// 자른 세로 기준으로 가로도 찾아보기
			int nowI = 0;
			int pastI= 0;
			for(int i = rNum; i < r + 1; i++) {
				if(square[i][0] == true || i == r) {
					pastI = nowI;
					nowI = i;
					rlen = Math.abs(pastI - nowI);
					flag = false;
					max = Math.max(max, clen * rlen);
					
				}
			}
			
			if(cNum > c-1) flag = true;
		}
		
		System.out.println(max);
		
		
	}
}
