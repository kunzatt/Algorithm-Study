import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 가장 처음 아기 상어 크기 : 2
// 자신보다 큰 물고기가 있는 칸 못 지나감
// 자신의 크기보다 작은 물고기만 먹을 수 있고, 크기가 같으면 지나가기만 할 수 있음
// 먹을 수 있는 물고기가 있다 => 1마리면 먹으러감

public class Main16236_아기상어 {
	static int N;
	static int[][] map;
	static int[][] drc = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	static boolean[][] visited;
	static class Point {
		int r, c, time, size;

		public Point(int r, int c, int time, int size) {
			this.r = r;
			this.c = c;
			this.time = time;	// 시간
			this.size = size;  	// 크기

		}
	}
	static List<Point> fishList;	// 물고기 우선순위 기록하기 위해
	static Point start;
	static int eat;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		fishList = new ArrayList<>();
		eat = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9) { // 아기 상어면 저장
					start = new Point(i, j, 0, 2);
					map[i][j] = 0;
				}
			}
		}
		
		
		findFish();
		System.out.println(result);

	
		
	}
	
	
	static void findFish() {
		Queue<Point> que = new LinkedList<>();
		que.offer(start);
		visited[start.r][start.c] = true;

		while(true) {
			while(!que.isEmpty()) {
				Point p = que.poll();
				
				for(int d = 0; d < 4; d++) {
					int nr = p.r+drc[d][0];
					int nc = p.c+drc[d][1];
					
					if(!check(nr, nc) || visited[nr][nc]) continue;
					
					// 아기상어가 먹을 수 있으면 List에 추가하자
					if(map[nr][nc] < p.size && map[nr][nc] != 0) {
						que.offer(new Point(nr, nc, p.time+1, p.size));
						visited[nr][nc] = true;
						fishList.add(new Point(nr, nc, p.time+1, p.size));
					}
					
					// 이동만 가능한거면
					if(map[nr][nc] == p.size || map[nr][nc] == 0) {
						que.offer(new Point(nr, nc, p.time+1, p.size));
						visited[nr][nc] = true;
					}
				}
			}
			
			// 물고기 비어 있으면 
			if(!fishList.isEmpty()) {
				eatFish(); // 물고기 우선순위부터 먹자
				
				que.clear(); // 비우자
				visited = new boolean[N][N]; // 다시 초기화
				
				que.offer(start); // 다시 넣음
				visited[start.r][start.c] = true; 
			} else {
				return;
			}
		}
		
	}
	
	static void eatFish() {
		Collections.sort(fishList, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if(p1.time == p2.time) {
					if(p1.r == p2.r) {	// r 이 같으면
						if(p1.c > p2.c) return 1;
						else return -1;
					} else {
						if(p1.r > p2.r) return 1;
						else return -1;
					}
				} else if(p1.time > p2.time) return 1;
				else return -1;
			};
		});
		
		Point p = fishList.get(0); // 젤 우선순위 높은 생선
		
		// 상어 위치 젤 높은 애로 변경
		start.r = p.r;
		start.c = p.c;
		
		if(++eat == start.size) {
			start.size++;
			eat = 0;
		}
		
		result += p.time;
		
		// 해당 맵 0 처리
		map[p.r][p.c] = 0;
		
		// 비우기
		fishList.clear();
		
	}
	
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
