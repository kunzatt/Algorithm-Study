import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9996 {
	static int N;
	static String s;
	static String e;
	static String sen;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), "*");
		s = st.nextToken();
		e = st.nextToken();
		
		for(int t=0; t< N; t++) {
			sen = br.readLine();
			visited = new boolean[sen.length()];
			if(check(sen)) {
				System.out.println("DA");
			}else {
				System.out.println("NE");
			};
		}
		
	}

	private static boolean check(String sen) {
		if(sen.length() < s.length() + e.length()) {
			return false;
		}
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) != sen.charAt(i)) return false;
			visited[i] = true;
		}
		
		for(int i=0; i<e.length(); i++) {
			if(visited[sen.length()-e.length()+i]) return false;
			if(e.charAt(i) != sen.charAt(sen.length()-e.length()+i)) return false;
		}
		
		return true;
	}
}
