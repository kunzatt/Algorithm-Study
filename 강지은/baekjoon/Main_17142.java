import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142 {

	static int N, M;
	static int min;
	static int[][] map, tmp;
	static List<Cell> virus;
	static Cell[] select;
	static boolean[][] visit;
	static int time;
	static int notVirus, tmpNV;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Cell {
		int r;
		int c;
		int time;
		public Cell(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		tmp = new int[N][N];
		select = new Cell[M];
		virus = new ArrayList<>();
		notVirus = 0;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c]==0) {
					notVirus++;
				}
				if (map[r][c]==2) {
					virus.add(new Cell(r,c,0));
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		
		// 바이러스 위치 선택
		selectVirus(0, 0);
		
		if (notVirus==0) System.out.println(0);
		else System.out.println(min==Integer.MAX_VALUE ? -1 : min);
		
	}

	private static void selectVirus(int cnt, int idx) {
		if (cnt==M) {
			// 연구소 복원
			for (int r = 0; r < N; r++) {
				tmp[r] = Arrays.copyOf(map[r], N);
			}
			
			for (int i = 0; i < M; i++) {
				Cell virus = select[i];
				tmp[virus.r][virus.c] = -2;
			}
			
			visit = new boolean[N][N];
			
			// 바이러스 퍼짐
			tmpNV = notVirus;
			spreadVirus();
			
			
			return;
		}
		
		for (int i = idx; i < virus.size(); i++) {
			select[cnt] = virus.get(i);
			selectVirus(cnt+1, i+1);
		}
		
	}

	private static void spreadVirus() {
		Queue<Cell> que = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			que.add(select[i]);
			visit[select[i].r][select[i].c] = true;
		}
		
		while (!que.isEmpty()) {
			Cell cell = que.poll();
			int r = cell.r;
			int c = cell.c;
			int tm = cell.time;

			
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if (!check(nr, nc)) continue;
				if (visit[nr][nc] || map[nr][nc]==1) continue;
				
				if (tmp[nr][nc] == 0) {
					tmpNV--;
				}
				
				visit[nr][nc] = true;
				que.add(new Cell(nr,nc,tm+1));

				if (tmpNV == 0) {
					min = Math.min(min, tm+1);
					return;
				}
				
			}
		}
		
		return;
	}

	private static boolean check(int r, int c) {
		return 0<=r&&r<N&0<=c&&c<N;
	}

}
