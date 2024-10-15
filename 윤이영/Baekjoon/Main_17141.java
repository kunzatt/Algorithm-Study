import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17141 {
	static int N, M;
	static int[][] map;
	static int[][] tmap;
	static ArrayList<int[]> empty = new ArrayList<>();
	static int[][] time;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int mintime = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		tmap = new int[N][N];
		time = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					empty.add(new int[] {i, j});
				}
			}
		}
		
		Comb(0, 0);
		if(mintime == Integer.MAX_VALUE) {
			mintime = -1;
		}
		
		System.out.println(mintime);
	}

	private static void Comb(int depth, int start) {
		if(depth == M) {
			mintime = Math.min(TimeBfs(), mintime);
			return;
		}
		
		for(int i=start; i<empty.size(); i++) {
			int[] tmp = empty.get(i);
			tmap[tmp[0]][tmp[1]] = 2;
			Comb(depth+1, i+1);	// 뽑음
			tmap[tmp[0]][tmp[1]] = 0;	// 백트래킹
		}
	}

	private static int TimeBfs() {
		Queue<int[]> que = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				time[i][j] = -1;
				if(map[i][j] == 1) {
					time[i][j] = -10;
				}
				if(tmap[i][j] == 2) {
					time[i][j] = 0;
					que.add(new int[] {i, j});
				}
			}
		}

		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == 1) continue;
				if(time[nr][nc] == -1) {
					time[nr][nc] = time[r][c]+1;
					que.add(new int[] {nr, nc});
				}
			}
		}
		//System.out.println("que End");
		
		//print(time);
		
		int maxtime = 0;
		// 몇초만에 퍼뜨리는지 찾기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				maxtime = Math.max(maxtime, time[i][j]);
				if(time[i][j] == -1) {
					return Integer.MAX_VALUE;
				}
			}
		}
		
		
		//System.out.println(maxtime);
		//print(time);

		return maxtime;
	}

	private static boolean check(int r, int c) {
		// TODO Auto-generated method stub
		return r>=0 && r<N && c>=0 && c<N;
	}

	
	private static void print(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("----------------------------------");
	}
}
