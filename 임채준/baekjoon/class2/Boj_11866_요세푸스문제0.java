package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11866_요세푸스문제0 {
	
	static int N, K, count;
	static Queue<Integer> que = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i = K; i <= N; i++) {
			que.offer(i);
		}
		for(int i = 1; i < K; i++) {
			que.offer(i);
		}
		while(!que.isEmpty()) {
			sb.append(que.poll());
			if(!que.isEmpty()) sb.append(", ");
			else {
				sb.append(">");
				break;
			}
			count = 1;
			while(count != K) {
				int temp = que.poll();
				que.offer(temp);
				count++;
			}
		}
		System.out.print(sb);

	}
}