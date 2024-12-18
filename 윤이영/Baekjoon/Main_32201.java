import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_32201 {
	static int N;
	static Map<Integer, Integer> map = new HashMap<>();
	static int max;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int p = Integer.parseInt(st.nextToken());
			map.put(p, i);
		}
		
		max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int p = Integer.parseInt(st.nextToken());
			int u = map.get(p) - i;
			if( u > max) {
				max = u;
				list.clear();
			}
			if(max == u) {
				list.add(p);
			}
		}
		
		for(int s : list) {
			System.out.print(s+" ");
		}
		
	}
}
