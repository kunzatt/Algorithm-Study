import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1360 {
	static int N;
	static List<Node> list = new ArrayList<>();
	
	static class Node {
		String text;
		int time;
		
		public Node(String text, int time) {
			this.text = text;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list.add(new Node("", 0));
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String txt = st.nextToken();
			
			if(txt.equals("type")) {
				// 이전 시간의 명령어에 해당 문자를 추가한다.
				String chr = st.nextToken();
				int t = Integer.parseInt(st.nextToken());
				String curtxt = list.get(list.size()-1).text;
				
				list.add(new Node(curtxt+chr, t));
			}
			else {
				// undo 명령어 수행시
				int dur = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				int rt = t - dur;
				String reversetxt = "";
				for(int j=list.size()-1; j>=0; j--) {
					if(list.get(j).time < rt) {
						reversetxt = list.get(j).text;
						break;
					}
				}
				
				list.add(new Node(reversetxt, t));
				
			}
			
			
		}
		
		System.out.println(list.get(list.size()-1).text);
	}
}
