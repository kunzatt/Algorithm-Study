import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static List<Cheese> cheeseList;
	static int time;
	static int cnt;
	
	static class Cheese {
		int r;
		int c;
		public Cheese(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cheeseList = new ArrayList<>();
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1)
					cheeseList.add(new Cheese(r,c));
			}
		}
		
		cnt = cheeseList.size();
		while (cnt > 0) {
			
			visit = new boolean[N][M];
			outAir(0,0);			
			meltCheese();
			time++;
		}
		
		System.out.println(time);
	}

	private static void meltCheese() {
		
		for (int i = cheeseList.size()-1; i >= 0; i--) {
			int r = cheeseList.get(i).r;
			int c = cheeseList.get(i).c;
			
			if (map[r][c] != 1) continue;
			
			int out = 0;
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if (map[nr][nc] == 2)
					out++;
			}
			
			if (out>= 2) {
				map[r][c] = 0;
				cnt--;
				cheeseList.remove(i);
			}
			
		}
		
	}

	private static void outAir(int r, int c) {
		Queue<Cheese> queue = new LinkedList<>();
		queue.add(new Cheese(r, c));
		visit[r][c] = true;
		map[r][c] = 2;
		
		while (!queue.isEmpty()) {
			Cheese ch = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = ch.r+dr[d];
				int nc = ch.c+dc[d];
				
				if (!check(nr,nc)) continue;
				if (visit[nr][nc] || map[nr][nc] == 1) continue;
				queue.offer(new Cheese(nr, nc));
				visit[nr][nc] = true;
				map[nr][nc] = 2;
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}

}
