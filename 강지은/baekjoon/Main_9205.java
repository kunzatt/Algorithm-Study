import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205 { 

    static int T, N;
    static List<Node> list;
    static class Node {
    	int r;
    	int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        
        T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Node(r,c));
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				list.add(new Node(r,c));
			}
			
			st = new StringTokenizer(br.readLine());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			list.add(new Node(er,ec));
			
			bfs(er, ec);
		}
        
    }

	private static void bfs(int er, int ec) {
		Queue<Node> que = new LinkedList<>();
		que.add(list.get(0));
		
		boolean[] visit = new boolean[list.size()];
		visit[0] = true;
		
		while (!que.isEmpty()) {
			Node cur = que.poll();
			
			if (cur.r==er && cur.c==ec) {
				System.out.println("happy");
				return;
			}
			
			for (int i = 1; i < list.size(); i++) {
				if (visit[i]) continue;
				Node next = list.get(i);
				int dist = Math.abs(cur.r-next.r)+Math.abs(cur.c-next.c);
				
				if (dist <= 1000) {
					que.add(next);
					visit[i] = true;
				}
			}
		}
		
		System.out.println("sad");
	}
	
}
