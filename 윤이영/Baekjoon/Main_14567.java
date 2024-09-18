import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14567 {
	static int N, M;
	static ArrayList<Integer>[] adjlist;
	static int[] incnt;
	static int[] time;
	static int mintime = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjlist = new ArrayList[N];
		incnt = new int[N];
		time = new int[N];
		
		for(int i=0; i<N; i++) {
			adjlist[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			adjlist[s].add(e);
			incnt[e]++;
		}
		
		topology();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(time[i]+" ");
		}
		
		System.out.println(sb);
	}


	private static void topology() {
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			if(incnt[i] == 0) {
				que.add(i);
				time[i] = 1;
			}
		}
		
		while(!que.isEmpty()) {
			int cur = que.poll();

			for(int v : adjlist[cur]) {
				incnt[v]--;
				if(incnt[v]== 0) {
					que.add(v);
					time[v] = time[cur]+1;
				}
			}
			
		}
		
	}
}