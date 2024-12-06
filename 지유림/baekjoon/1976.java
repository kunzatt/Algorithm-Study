import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1976_여행스팟 {
	static int N, M;
	static int[][] map;
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 도시의 개수 : N
		N = Integer.parseInt(br.readLine());
		
		// 여행 계획에 포함될 도시의 수 : M
		M = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		p = new int[N+1];
		for(int i = 1; i < N; i++) {
			p[i] = i;
		}
		
		for(int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {	// 연결되었으면 부모연결!
					union(i, j);
				}
			}
		} 
		
		List<Integer> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}

		
		
		int first = find(arr.get(0));	// 처음 여행지
		for(int i = 1; i < M; i++) {
			if(first != find(arr.get(i))) {
				System.out.println("NO");
				return;
			}
			
		}
		System.out.println("YES");
	}
	
	static int find(int x) {
		if(x != p[x]) p[x] = find(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		x = find(x);
		y= find(y);
		
		if(x < y) {
			p[y] = x;
		} else {
			p[x] = y;
		}
	}
}
