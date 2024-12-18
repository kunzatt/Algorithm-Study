import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 구간나누기 : subset
// 나눈 구간이 연결되어 있는지 확인하기 : bfs 
public class Main17471_게리맨더링 {
	static int N, min;
	static int[][] map;
	static int[] human;	// 각 인구수 담을 배열
	static boolean[] visited;	// subset 방문
	static boolean[] bVisited;  // bfs 방문 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		

		
		map = new int[N][N];
		human = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			human[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				int e = Integer.parseInt(st.nextToken())-1;
				map[i][e] = 1;
				map[e][i] = 1;
			}
		}

		min = 1000000;
		subset(0);
		if(min == 1000000) min = -1;
		System.out.println(min);
		
	}
	
	// 먼저 선거구 나누기 위해서 subset
	static void subset(int cnt) {
		if(cnt == N) {
			int num = connect();
			min = Math.min(num, min);

			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
	}
	
	// 선거구를 돌면서 다 이어져있는지 확인하기
	static int connect() {
		List<Integer> aZone = new ArrayList<>();	// A구간
		List<Integer> bZone = new ArrayList<>();	// B구간
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) aZone.add(i);
			else bZone.add(i);
		}
		
		// 둘 중에 하나가 0이면 구간이 한쪽으로 몰리면 없음!!
		// 아예 큰 값 보내줘서 min 값 비교 못하게하기
		if(aZone.size() == 0 || bZone.size() == 0) return 10000000;
		
		// 나눠진 구간들이 서로 연결 되어 있는지 확인해보기
		bVisited = new boolean[N];
		bfs(aZone);
		bfs(bZone);
		
		// 0 : aZone.size(); / 1 : bZone.size();
		
		for(int i = 0; i < N; i++) {
			if(!bVisited[i]) return 10000000;
		}
		
		
		return calc(aZone, bZone);
		
	}
	
	// 구간을 확인하기 위해선 너비우선으로 넓게~~
	static void bfs(List<Integer> list) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(list.get(0));	// 가장 첫번째 값 넣어주기
		bVisited[list.get(0)] = true;	// 방문 완료
		
		while(!que.isEmpty()) {
			int s = que.poll();
			
			for(int e = 0; e < list.size(); e++) {
				if(bVisited[list.get(e)]) continue;
				if(map[s][list.get(e)] == 1) {	// 이어졌다!
					
					que.offer(list.get(e));
					bVisited[list.get(e)] = true; // 여기 확인요
				}
			}
		}
	}
	
	// 구간별 인구수 찾아보기
	static int calc(List<Integer> az, List<Integer> bz) {
		int aSum = 0;
		int bSum = 0;
		
		for(int i = 0; i < az.size(); i++) {
			aSum += human[az.get(i)];
		}
		
		for(int i = 0; i < bz.size(); i++) {
			bSum += human[bz.get(i)];
		}
		
		return Math.abs(aSum-bSum);
	}
}
