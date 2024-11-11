import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_171411 {

	static int N, M;
	static int min;
	static int[][] map, tmp;
	static List<Cell> virus;
	static Cell[] select;
	static boolean[][] visit;
	static boolean flag;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Cell {
		int r;
		int c;
		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
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
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c]==2) {
					virus.add(new Cell(r,c));
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		
		// 바이러스 위치 선택
		selectVirus(0, 0);
		
		System.out.println(min==Integer.MAX_VALUE ? -1 : min);
		
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
			int time = 0;
			
			while (true) {
				// 바이러스를 못 퍼트리는지
				if (!isPossible()) {
					break;
				}
				
				// 바이러스가 모두 퍼졌는지 확인
				if (isComplete()) {
					min = Math.min(min, time);
					break;
				}
								
				// 바이러스 퍼짐
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (tmp[r][c] == -2 && !visit[r][c]) {
							visit[r][c] = true;
							spreadVirus(r, c);
						}
					}
				}
				
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (tmp[r][c] == -1)
							tmp[r][c] = -2;
					}
				}				
				
				time++;
				if (min <= time) break;
				
			}
			
			return;
		}
		
		for (int i = idx; i < virus.size(); i++) {
			select[cnt] = virus.get(i);
			selectVirus(cnt+1, i+1);
		}
		
	}

	private static boolean isPossible() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (tmp[r][c] == -2 && !visit[r][c])
					return true;
			}
		}
		return false;
	}

	private static boolean isComplete() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (tmp[r][c] == 0 || tmp[r][c] == 2) return false;
			}
		}
		return true;
	}

	private static void spreadVirus(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if (!check(nr, nc)) continue;
			if (tmp[nr][nc]==1 || tmp[nr][nc] < 0) continue;
			tmp[nr][nc] = -1;
		}
	}

	private static boolean check(int r, int c) {
		return 0<=r&&r<N&0<=c&&c<N;
	}

}
