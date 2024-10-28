import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 1. 미세먼지 확산
 * 2. 공기청정기
 * 3. 남아있는 미세먼지의 양 계산
 */
public class Main_17144 {
	static int R, C, T;
	static int[][] map;
	static int[][] temp;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};	// 상, 우, 하, 좌
	static int[] dc = {0, 1, 0, -1};
	static int ans;
	static List<Integer> clearmachine = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		temp = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) clearmachine.add(i);
			}
		}
		
		for(int t=1; t<=T; t++) {
			// 1. 미세먼지 확산 - 이때, 동시에 확산된다는 점을 주의한다.
			
			// 1-1: 원본 2차원 배열을 복사한다.
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			// 1-2: 복사한 원본 배열의 값(temp)을 기준으로 미세먼지가 확산되는 양을 계산하여 map에 기록한다
			spreadMise();
			//print();
			clearMise();
			
			ans = calculate();
		}
		
		System.out.println(ans);
		
	}

	private static int calculate() {
		int total = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] > 0) total += map[r][c];
			}
		}
		return total;
	}

	private static void print() {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
		
		System.out.println("-----------------");
	}

	private static void spreadMise() {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(temp[r][c] >= 0) {
					// 미세먼지가 있다면 확산 시작;
					int flag = 0;	// 미세먼지가 확산된 방향의 개수
					int m = temp[r][c] / 5;	// 미세먼지가 확산되는 양
					// 4방향을 체크한다.
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(!check(nr, nc) || temp[nr][nc] == -1) continue;
						flag++;
						map[nr][nc] += m;	// 확산된 양을 기존 값에 더하기
					}
					
					map[r][c] = map[r][c] - (m*flag);
				}
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<R && c>= 0 && c<C;
	}

	private static void clearMise() {
		// 위쪽 공기청정기 순환
		int sr = clearmachine.get(0);
		// 바람이 순환하는 방향의 역으로 계산
		for(int r=sr-1; r>0 ; r--) {
			map[r][0] = map[r-1][0];
		}
		for(int c=0; c<C-1; c++) {
			map[0][c] = map[0][c+1];
		}
		for(int r=0; r<sr; r++) {
			map[r][C-1] = map[r+1][C-1];
		}
		for(int c=C-1; c>0; c--) {
			map[sr][c] = map[sr][c-1];
		}
		map[sr][1] = 0;
		
		
		
		// 아래쪽 공기청정기 순환
		sr = clearmachine.get(1);
		for(int r = sr+1; r<R-1; r++) {
			map[r][0] = map[r+1][0];
		}
		for(int c=0; c<C-1; c++) {
			map[R-1][c] = map[R-1][c+1];
		}
		for(int r=R-1; r>sr ; r--) {
			map[r][C-1] = map[r-1][C-1];
		}
		for(int c=C-1; c>0; c--) {
			map[sr][c] = map[sr][c-1];
		}
		map[sr][1] = 0;
		
		//print();
		
	}
}
