import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main15686_치킨배달 {
	static int N, M;
	static int[][] map;
	static List<Home> homeList;
	static List<Chicken> chList;
	static Chicken[] chMap;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[] visited;
	static int result;
	
	static class Home {
		int r, c;

		public Home(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "home [r=" + r + ", c=" + c + "]";
		}
	}
	
	static class Chicken {
		int r, c;

		public Chicken(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Chicken [r=" + r + ", c=" + c + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		homeList = new ArrayList<>();
		chList = new ArrayList<>();
		
		chMap = new Chicken[M];

		
		// 0: 빈 칸, 1: 집, 2: 치킨집
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					homeList.add(new Home(i, j));
				} else if(map[i][j] == 2) {
					chList.add(new Chicken(i, j));
				}
			}
		}
		
		visited = new boolean[chList.size()];
		
		
		result = 10000;
		combi(0, 0);
		
	
		System.out.println(result);
	}
	
	static void combi(int cnt, int start) {
		if(cnt == M) {
			int min = calc(chMap);
			result = Math.min(result, min);	
			return;
		}
		
		for(int i = start; i < chList.size(); i++) {
			if(visited[i]) continue;
			visited[i] = true;
			chMap[cnt] = chList.get(i);
			combi(cnt+1, i+1);
			visited[i] = false;
		}
	}
	
	static int calc(Chicken[] cm) {
		int result = 0;
		
		for(int i = 0; i < homeList.size(); i++) {
			int min = 100000;
			int r1 = homeList.get(i).r;	// 집 r
			int c1 = homeList.get(i).c; // 집 c
			for(int j = 0; j < cm.length; j++) {
				int r2 = cm[j].r;	// 뽑힌 치킨집 r
				int c2 = cm[j].c;	// 뽑힌 치킨집 c

				int R = Math.abs(r1 - r2);
				int C = Math.abs(c1 - c2);
				
				min = Math.min(R+C, min);
			}
			result += min;
		}
		
		return result;
	}
}
