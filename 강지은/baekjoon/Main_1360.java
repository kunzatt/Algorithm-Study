import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1360 {
    
	static int T;
	static List<Node> arr;
	static class Node {
		int time;
		String text;
		public Node(int time, String text) {
			this.time = time;
			this.text = text;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        arr = new ArrayList<>();
        arr.add(new Node(0, ""));
        
        
        for (int i = 0; i < T; i++) {
        	boolean flag = false;
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.equals("type")) {
				StringBuilder sb = new StringBuilder();
				String text = st.nextToken();
				int time = Integer.parseInt(st.nextToken());
				
				sb.append(arr.get(arr.size()-1).text).append(text);
				arr.add(new Node(time, sb.toString()));
				
			} else {
				int back = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				
				for (int j = i; j >= 0; j--) {
					if (time-back-1 < 0) {
						break;
					}
					
					Node node = arr.get(j);
					if (node.time<=time-back-1) {
						arr.add(new Node(time, node.text));
						flag = true;
						break;
					}
				}
				
				if (!flag) {
					arr.add(new Node(time, ""));
				}
			}
			
		}
        
        System.out.println(arr.get(arr.size()-1).text);
    }

}
