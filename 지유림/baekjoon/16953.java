import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16953_AB {
	static long A, B;
	static class Min {
		long a, cnt;

		public Min(long a, long cnt) {
			super();
			this.a = a;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		
		System.out.println(bfs());
	}
	
	static long bfs() {
		Queue<Min> que = new LinkedList<>();
		que.offer(new Min(A, 1));
		
		while(!que.isEmpty()) {
			int size = que.size();
			
			for(int i = 0; i < size; i++) {
				Min m = que.poll();
				
				if(m.a == B) {
					
					return m.cnt;
				}
				
				if(m.a*2 <= B) que.offer(new Min(m.a*2, m.cnt+1));
				
				long a = Long.parseLong(m.a+"1");
				if(a <= B) que.offer(new Min(a, m.cnt+1));
			}
		}
		
		return -1;
	}
}
