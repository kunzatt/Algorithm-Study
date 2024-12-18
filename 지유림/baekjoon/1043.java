import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 입력값이 뭔가 유니온파인드같음
// 유니온 파인드 응용하기 어렵다..;;
public class Main1043_거짓말 {
	static int N, M;
	static boolean[] truth;
	static int[] people;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		truth = new boolean[51]; // 알고있는사람들
		people = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			people[i] = i;
		}
		
		// 진실을 아는 사람들 정보 받아오기
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		
		if(num == 0) {
			System.out.println(M);
		} else {
			for(int i = 0; i < num; i++) {
				int know = Integer.parseInt(st.nextToken());
				truth[know] = true; // 진실을 알고있다
			}
			
			
			// 파티정보 받기 & union
			ArrayList<Integer>[] party = new ArrayList[M];
			for(int i = 0; i < M; i++) {
				party[i] = new ArrayList<>();
			}
			
			int x = 0;
			int y = 0;
			int n = 0;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());
				
				// 연결하기
				if(n > 0) {
					x = Integer.parseInt(st.nextToken());
					party[i].add(x);
				}
				
				for(int j = 1; j < n; j++) {
					y = Integer.parseInt(st.nextToken());
					party[i].add(y);
					
					union(x, y);
				}
			}
			
			// 진실여부 확인하기
			for(int i = 1; i < truth.length; i++) {
				if(truth[i]) {
					truth[find(i)] = true;
				}
			}
			
			int count = 0;
			int p = 0;

			for(int i = 0; i < M; i++) {
				if(party[i].size() > 0) {
					p = find(party[i].get(0));
					if(!truth[p]) count++;	// 진실을 아는사람과 연관이 없으묜
				}
			}
			
			System.out.println(count);
		}
				
	}
	
	static int find(int x) {
		if(people[x] == x) return people[x] = x;
		else return find(people[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			people[y] = x;
		} else return;
	}
}
