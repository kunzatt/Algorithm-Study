import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 약 1시간 반 소요 */
// 1. 메모리 초과 - 큐에 넣을 때 visit 처리를 해주지 않았더니 발생했다
// 2. 빙산 녹이는 파트 - 인접 칸의 빙산이 녹아버릴 경우, 0으로 바뀌면서 인접한 다음 빙산이 더 많이 녹게 됨. (visit으로 처리!)
/*
5 5
0 0 0 0 0
0 0 9 0 0
0 0 3 1 0
0 0 9 0 0
0 0 0 0 0
*/

public class Main_2573 {
	static int N, M;
	static int[][] map;
	static int[][] check;
	static int time=0;
	static int count=1;
	static int ice=0;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new int[N][M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c =0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] != 0) ice++;
			}
		}
		
		while(ice > 0) {
			count = 11;
			clear(check);	// 체크 배열을 초기화 하는 함수
			
			// 빙산 덩어리의 개수를 세기
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c] != 0 && check[r][c] == 0) {
						floodfill(r,c);
						//print(check);
						count++;
					}
				}
			}
			
			// 빙산 녹이기
			clear(check);
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c] != 0) {
						int melting = 0;
						check[r][c] = 10;
						for(int d=0; d<4; d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							if(check[nr][nc] > 0) continue;
							if(map[nr][nc]==0) melting++;
						}
						map[r][c] -= melting;
						if(map[r][c] <= 0) {
							ice--;
							map[r][c] = 0;
						} 
							
					}
				}
			}
			//print(map);
			//System.out.println(count);
			if(count-11 >= 2) {	// 덩어리가 두개 이상이라면
				System.out.println(time);
				return;	// 프로그램 종료
			}			
			time++;
		}
		
		time = 0;
		System.out.println(time);
	}
	
	private static void clear(int[][] check2) {
		for(int r=0; r<N; r++) {	// 체크 배열 초기화
			for(int c=0; c<M; c++) {
				check[r][c] = 0;
			}
		}
	}

	private static void floodfill(int sr, int sc) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {sr, sc});
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			check[r][c] = count;
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(!possible(nr, nc)) continue;
				if(map[nr][nc] == 0) continue;
				if(check[nr][nc] == 0) {
					que.add(new int[] {nr, nc});
					check[nr][nc] = count;
				}
			}
			
		}
	}

	private static boolean possible(int r, int c) {
		return r>=0 && r< N && c>=0 && c<M;
	}
	
	static void print(int[][] maps) {
		for(int r=0; r<N; r++) {
			for(int c =0; c<M; c++) {
				System.out.print(maps[r][c]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}
}