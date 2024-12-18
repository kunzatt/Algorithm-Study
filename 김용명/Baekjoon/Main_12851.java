import java.io.*;
import java.util.*;

public class Main_12851 {
	
	static int N, K, min, count;
	static int[] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		check = new int[100001];
		min = Integer.MAX_VALUE;
		count = 0;
		
		// 예외처리
		if (N >= K) {
			System.out.println((N-K) + "\n1");
			return;
		}
		
		bfs(N);
		System.out.println(min + "\n" + count);

	}

	static void bfs(int num) {
		
		Queue<Integer> que = new LinkedList<>();
		que.add(num);
		check[num] = 1;
		
		while (!que.isEmpty()) {
			int temp = que.poll();

			if (min < check[temp]) continue;
			
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = temp - 1;
				}else if (i == 1) {
					next = temp + 1;
				}else {
					next = temp * 2;
				}
				
				if (next < 0 || next >= check.length) continue;
				
				if (next == K) {
					min = check[temp];
					count++;
				}
				
				if (check[next] == 0 || check[next] == check[temp] + 1) { // 이미 방문했어도 같은 시간에 방문했다면 경우의수에 추가해야한다.
					que.add(next);
					check[next] = check[temp] + 1;
				}
				
			}
		}
				
	}

}
