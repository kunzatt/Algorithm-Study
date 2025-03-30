package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj_11279_최대힙 {
	
	static int N, num;
	static PriorityQueue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(que.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(que.poll()).append("\n");
				}
			} else {
				que.offer(num);
			}
		}
		System.out.println(sb);

	}

}
