import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1194_달이차오른다가자 {
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static boolean[] key;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Point {
		int r, c, d, k;

		public Point(int r, int c, int d, int k) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.k = k;
		}
	}
	static Queue<Point> p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][64];
		
		
		p = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '0') {
					p.offer(new Point(i, j, 0, 0));
				}
			}
		}
		
		
		System.out.println(bfs(p));
		
		
				
	}
	
	// 각각의 키를 비트로 표현하여 구분하기
	// a : 000001(1)
	// b : 000010(2)
	// c : 000100(4)
	// d : 001000(8)
	// e : 010000(16)
	// f : 100000(32)
	static int bfs(Queue<Point> que) {
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			// 출구를 만나면 탈출 -> 걸린 이동횟수를 반환함
			if(map[p.r][p.c] == '1') {
				return p.d;
			}
			
			// 수평, 수직 -> 4방 돌려서 확인하기
			for(int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				int nk = p.k;
				int nd = p.d;
				
				// 범위벗어났거나, 벽(#) 이면 못감
				if(!check(nr, nc) || map[nr][nc] == '#') continue;
				if(visited[nr][nc][nk]) continue;
				if(map[nr][nc] >= 'a' && 'z' >= map[nr][nc]) {	// 키를 만나면
					// 키를 만나면 키의 값으로 변경함
					int key = 1 << (map[nr][nc]-'a');	// 'a'만큼 빼주면, 키 값이 나온다
					
					key = key | nk;	// 기존의 키와 OR 연산자를 통해서 다시 생성
					visited[nr][nc][key] = true;
					que.offer(new Point(nr, nc, nd+1, key));
					
				} else if(map[nr][nc] >= 'A' && 'Z' >= map[nr][nc]) {	// 대문자 : 문
					int isKey = 1 << map[nr][nc] - 'A';		// 문에 맞는 키 값 구하기
					if((isKey & nk) > 0) {	
						// & 연산자를 이용했기 때문에 같은 자리에 1이 아니면 0
						// 맞는 키가 없으면 0이 나오고, 있으면 똑같은 수가 나옴
						visited[nr][nc][nk] = true;	// 키 있는거니까 true
						que.offer(new Point(nr, nc, nd+1, nk));
					}
				} else {	// 키, 문, 벽이 아닐땐 그냥 넣어주자
					visited[nr][nc][nk] = true;
					que.offer(new Point(nr, nc, nd+1, nk));
				}
			}
			
		}
		
		return -1;
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
