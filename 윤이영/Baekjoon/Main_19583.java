import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_19583 {
	static String S, E, Q;
	static Set<String> checked = new HashSet<>();
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = st.nextToken();
		E = st.nextToken();
		Q = st.nextToken();
		
		String t;
		while((t = br.readLine()) != null) {
			if (t.trim().isEmpty()) {
                break; // 빈 문자열이 입력되면 반복문 종료
            }
			st = new StringTokenizer(t, " ");
			String time = st.nextToken();
			String name = st.nextToken();
			
			// 입장 00 <= time <= S
			// 퇴장  E <= time <= Q
			if(time.compareTo(S) <= 0) {
				checked.add(name);
			}else if(time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
				// 입장한 학생의 경우;
				if(checked.contains(name)) {
					count++;
					checked.remove(name);
				}
			}
			
		}
		
		System.out.println(count);
		
	}
	
}
