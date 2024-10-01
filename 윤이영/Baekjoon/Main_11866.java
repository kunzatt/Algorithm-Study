import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11866 {
	static int N, K;
	static Queue<Integer> que = new LinkedList<>();
	static ArrayList<Integer> nlist = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			que.add(i);
		}
		
		while(!que.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				int tmp = que.poll();
				que.add(tmp);
			}

			nlist.add(que.poll());
		}
		
		StringBuilder sb = new StringBuilder("<");
		for(int i=0; i<N-1; i++) {
			sb.append(nlist.get(i)+","+" ");
		}
		sb.append(nlist.get(N-1));
		sb.append(">");
		System.out.println(sb);
	}
}
