import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {
	static int M, N, H;
	static int[][][] map;
	static int[] dr = {-1, 0, 1, 0, 0, 0};
	static int[] dc = {0, 1, 0, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};
	static Queue<int[]> que = new LinkedList<>();
	static boolean flag = true;
	static int maxtime;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[N][M][H];
		
		for(int i=0; i<H; i++) {
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r][c][i] = Integer.parseInt(st.nextToken());
					if(map[r][c][i] == 1) {
						que.add(new int[] {r, c, i});
					} 
				}
			}
		}	// 입력 끝
		
		bfs();

		if(!flag) {
			maxtime = -1;
		}
		
		System.out.println(maxtime);
		
	}
	private static void bfs() {
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			int h = cur[2];
			
			for(int d=0; d<6; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				int nh = h+dh[d];
				
				if(!check(nr, nc, nh)) continue;
				if(map[nr][nc][nh] == 0) {
					map[nr][nc][nh]  = map[r][c][h] + 1;
					que.add(new int[] {nr, nc, nh});
				}
			}
		}
		
		maxtime = 0;
		for(int i=0; i<H; i++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					maxtime = Math.max(maxtime, map[r][c][i]);
					if(map[r][c][i]== 0) {
						flag = false;
					}
				}
			}
		}
		
		maxtime--;
		
	}
	private static boolean check(int r, int c, int h) {
		// TODO Auto-generated method stub
		return r>=0 && r<N && c>=0 && c<M && h>=0 && h<H;
	}
	private static void print(int[][][] map2) {
		for(int i=0; i<H; i++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					System.out.print(map[r][c][i]+" ");
				}
				System.out.println();
			}
			System.out.println("-------------------------------");
		}	
	}

}
