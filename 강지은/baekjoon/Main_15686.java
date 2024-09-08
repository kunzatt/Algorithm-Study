import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686 {

	static int N, M;
	static int[][] map;
	static List<int[]> house;
	static List<int[]> chicken;
	static int[][] sChicken;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int sum;
	static int min;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		sChicken = new int[M][2];
		visit = new boolean[N][N];	
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1)
					house.add(new int[] {r,c});
				if (map[r][c] == 2)
					chicken.add(new int[] {r, c});
			}
		}
		
		min = Integer.MAX_VALUE;
		select(0, 0);
		System.out.println(min);
		
	}

	private static void select(int start, int cnt) {		
		if (cnt == M) {
			sum = 0;
			distance(sChicken);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			int r = chicken.get(i)[0];
			int c = chicken.get(i)[1];
			
			if (visit[r][c]) continue;
			visit[r][c] = true;
			sChicken[cnt] = chicken.get(i);
			select(i, cnt+1);
			visit[r][c] = false;
		}
		
	}

	private static void distance(int[][] list) {
		for (int i = 0; i < house.size(); i++) {
			int r = house.get(i)[0];
			int c = house.get(i)[1];
			
			int dist =Integer.MAX_VALUE;
			for (int j = 0; j < list.length; j++) {
				int distR = Math.abs(r-list[j][0]);
				int distC = Math.abs(c-list[j][1]);
				
				dist = Math.min(dist, distR+distC);
			}
			sum += dist;
			
		}

	}

}
