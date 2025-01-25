import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 {
    
	static int N, M, cnt;
	static int[][] map;
	static List<Cheese> cheese;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static boolean[][] visit;
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
        cheese = new ArrayList<>();
        
        for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c]==1) cheese.add(new Cheese(r, c));
			}
		}
        
        cnt = cheese.size();
        int last = 0;
        int time = 0;
        
        while (cnt > 0) {
        	visit = new boolean[N][M];
        	outAir(0,0);
        	last = meltCheese();
        	time++;
        }
        
        System.out.println(time);
        System.out.println(last);
        
    }


	private static int meltCheese() {
		int melt = 0;
		
		for (int i = cheese.size()-1; i >= 0; i--) {
			int r = cheese.get(i).r;
			int c = cheese.get(i).c;
			
			int out = 0;
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if (!check(nr,nc)) continue;
				if (map[nr][nc] == 2) out++;
			}
			
			if (out > 0) {
				map[r][c] = 0;
				cnt--;
				melt++;
				cheese.remove(i);
			}
		}
		
		return melt;
		
	}


	private static void outAir(int r, int c) {
		Queue<Cheese> que = new LinkedList<>();
		que.add(new Cheese(r,c));
		visit[r][c] = true;
		map[r][c] = 2;
		
		while (!que.isEmpty()) {
			Cheese cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				
				if (!check(nr,nc)) continue;
				if (map[nr][nc]==1 || visit[nr][nc]) continue;
				que.add(new Cheese(nr, nc));
				visit[nr][nc] = true;
				map[nr][nc] = 2;
			}
		}
		
	}


	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}
    
}
