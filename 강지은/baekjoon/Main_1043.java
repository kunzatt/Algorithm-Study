import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1043 {
    
	static int N, M, K;
	static int[] p;
	static List<Integer> know;
	static ArrayList<Integer>[] party;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st= new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        
        if (K==0) {
        	System.out.println(M);
        	return;
        }
        
        know = new ArrayList<>();
        for (int i = 0; i < K; i++) {
			know.add(Integer.parseInt(st.nextToken()));
		}
        
        p = new int[N+1];
        makeset();
        
        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			
			int first = Integer.parseInt(st.nextToken());
			party[i].add(first);
			
			for (int j = 1; j < size; j++) {
				int person = Integer.parseInt(st.nextToken());
				union(first, person);
				party[i].add(person);
			}
		}
        
        int cnt = 0;
        for (int i = 0; i < M; i++) {
			if (know.contains(find(party[i].get(0)))) continue;
			cnt++;
		}
        
        System.out.println(cnt);
        
    }

	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if (px==py) return;
		
		if (know.contains(py)) {
			int tmp = px;
			px = py;
			py = tmp;
		}
		
		p[py] = px;
	}

	private static int find(int x) {
		if (p[x]==x) return x;
		return find(p[x]);
	}

	private static void makeset() {
		for (int i = 1; i < N+1; i++) {
			p[i]=i;
		}
		
	}

}
