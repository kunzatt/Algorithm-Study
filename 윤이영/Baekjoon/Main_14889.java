import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int diff = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0);
		
		System.out.println(diff);
	}

	private static void comb(int idx, int count) {
		if(count == N/2) {
			getDiff();
			return;
		}
		
		for(int i=idx; i<N; i++) {
			visited[i] = true;
			comb(i+1, count+1);
			visited[i] = false;
		}
	}

	private static void getDiff() {
		int start = 0;
		int link = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(visited[i] && visited[j]) {start += map[i][j];}
				if(!visited[i] && !visited[j]) {link += map[i][j];}
			}
		}
		
		diff = Math.min(Math.abs(start - link) , diff);
		
	}
}