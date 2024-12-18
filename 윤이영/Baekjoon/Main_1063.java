import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063 {
	static int kx,ky;
	static int rx, ry;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// King 표시
		String K = st.nextToken();
		ky= K.charAt(0) - 65;
		kx = 8 - (K.charAt(1)- '0');
		// 돌 표시
		String R = st.nextToken();
		ry= R.charAt(0) - 65;
		rx = 8 - (R.charAt(1)- '0');

		int N = Integer.parseInt(st.nextToken());	//N번 이동 수행

			
		for(int t=0; t<N; t++) {
			String M = br.readLine();	// 이동 방향을 입력 받음
			int x = 0;
			int y = 0;
			if(M.contains("L")) {
				y--;
			}
			if(M.contains("R")) {
				y++;
			}
			if(M.contains("T")) {
				x--;
			}
			if(M.contains("B")) {
				x++;
			}
			
			if(check(kx+x,ky+y)) {	// 이동한 King이 범위 내에 있는지 확인
				if(Rcheck(kx+x, ky+y)) {	// 만약 돌이 King이 이동할 자리에 있다면 돌을 이동시켜야 함
					if(check(rx+x, ry+y)) {	// 만약 돌이 이동시에 범위 밖으로 나가지 않는다면: 돌 이동
						rx += x;
						ry += y;
					}
					else {	// 만약 독이 범위 밖으로 나간다면: 이동할 값을 0으로 바꿔서 킹 또한 이동하지 못하게 함.
						x = 0;
						y=0;
					}
				}
				kx += x;	// 킹 이동
				ky+= y;		
			}
		}
		
		System.out.println((char)(ky+'A')+""+(8-kx));	// 문제 조건에 맞게 xy값을 변환
		System.out.println((char)(ry+'A')+""+(8-rx));
	}
	
	// 킹이 이동 시에 돌과 겹치는지 확인하는 메서드
	private static boolean Rcheck(int i, int j) {
		return i==rx && j == ry;
	}
	
	// 이동한 후에 범위 내에 있는지 확인
	private static boolean check(int x, int y) {
		return x>= 0 && x<8 && y>=0 && y<8;
	}
}
