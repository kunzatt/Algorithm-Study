
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {
    
	static int N, M;
	static int[][] map, tmp;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static List<Zone> zoneList;
	static Zone[] selectList;
	static boolean[] visit;
	static int size, safe, max;
	
	static public class Zone {
		int r;
		int c;
		public Zone(int r, int c) {
			super();
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
		tmp = new int[N][M];
		zoneList = new ArrayList<>();
		selectList = new Zone[3];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				tmp[r][c] = map[r][c];
				if (map[r][c] == 0) {
					zoneList.add(new Zone(r,c));
				}
			}
		}
		
		max = 0;
		size = zoneList.size();
		safe = size;
		visit = new boolean[size];
		select(0,0);
		
		System.out.println(max);
	}

	private static void select(int idx, int depth) {
		if (depth==3) {
			
			// 벽세우기
			block();
			safe -= 3;
			
			// 바이러스 퍼짐
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (tmp[r][c]==2) virus(r,c);
				}
			}
			
			// 영역 카운트
			max = Math.max(max, safe);
			
			// 맵 원상복귀
			for (int i = 0; i < N; i++) {
				tmp[i] = Arrays.copyOf(map[i], M);
			}
			safe = size;
			
			return;
		}
		
		
		
		for (int i = idx; i < size; i++) {
			if (visit[i]) continue;
			int zoneR = zoneList.get(i).r;
			int zoneC = zoneList.get(i).c;
			selectList[depth] = new Zone(zoneR,zoneC);
			visit[i] = true;
			select(i+1, depth+1);
			visit[i] = false;
		}
	}

	private static void virus(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		que.add(new int[] {r,c});
		visited[r][c] = true;
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if (!check(nr, nc)) continue;
				if (visited[nr][nc] || tmp[nr][nc] > 0) continue;
				que.add(new int[] {nr,nc});
				visited[nr][nc] = true;
				tmp[nr][nc] = 3;
				safe--;
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}

	private static void block() {
		for (int i = 0; i < 3; i++) {
			int r = selectList[i].r;
			int c = selectList[i].c;
			tmp[r][c] = 1;
		}
		
	}
}
