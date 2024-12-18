import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 뒤집으라 했다고 진짜 뒤집으면 시간초과 ㅎㅎ;
public class Main5430_AC2 {
	static int T, n;
	static String p;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
			p = br.readLine();
			n = Integer.parseInt(br.readLine());

			Deque<Integer> deq = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			for(int i = 0; i < n; i++) {
				deq.add(Integer.parseInt(st.nextToken()));
			}
			
			ac(deq);
			
		}
		
		System.out.println(sb);
	}
	
	
	static void ac(Deque<Integer> deq) {
		boolean isReverse = false;	// 리버스 여부
		
		for(int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			
			if(c == 'R') {
				if(isReverse) isReverse = false;
				else isReverse = true;
			} else if(c == 'D') {
				
				if(isReverse) {	// 역방향일 때
					if(deq.pollLast() == null) {
						sb.append("error").append("\n");
						return;
					}
				} else {	// 정방향일 때
					if(deq.pollFirst() == null) {
						sb.append("error").append("\n");
						return;
					}
				}
			}
		}
		
		print(deq, isReverse);
	}
	
	static void print(Deque<Integer> deq, boolean isReverse) {
		sb.append("[");
		
		if(deq.size() > 0) {
			if(!isReverse) {	// 정방향일 때, 그냥 그대로 출력!
				sb.append(deq.pollFirst());
				while(!deq.isEmpty()) {
					sb.append("," + deq.pollFirst());
				}
			} else {	// 역방향일 때 뒤에서부터
				sb.append(deq.pollLast());
				while(!deq.isEmpty()) {
					sb.append("," + deq.pollLast());
				}
			}
		}
		
		sb.append("]").append("\n");
	}
}
