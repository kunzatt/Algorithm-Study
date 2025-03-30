package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_2164_카드2 {
	
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }
        
        while (que.size() > 1) {
            que.poll();
            if (!que.isEmpty()) {
                que.offer(que.poll());
            }
        }
        
        System.out.println(que.poll());

	}

}
