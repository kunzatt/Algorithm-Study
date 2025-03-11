import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1374 {
	
	static int N;
	static PriorityQueue<Node> pq;
	static PriorityQueue<Integer> lecture;
	static class Node implements Comparable<Node> {
		int num;
		int start;
		int end;
		public Node(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Node o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        lecture = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(n,s,e));
		}
        
        int max = 0;
        while (!pq.isEmpty()) {
        	Node cur = pq.poll();
        	
        	while (!lecture.isEmpty()) {
        		if (lecture.peek() <= cur.start) {
        			lecture.poll();
        		} else break;
        	}
        	
        	lecture.add(cur.end);
        	max = Math.max(max, lecture.size());
        }
        
        System.out.println(max);
        
    }

}
