import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2470 {

	static int N;
	static List<Integer> potion;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		potion = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			potion.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(potion);
		
		int lo = 0;
		int hi = N-1;
		
		int ans = Integer.MAX_VALUE;
		int ansL = 0;
		int ansR = 0;
		while (lo < hi) {
			int mix = potion.get(lo)+potion.get(hi);
			if (Math.abs(0-mix) < Math.abs(0-ans)) {			
				ans = mix;
				ansL = potion.get(lo);
				ansR = potion.get(hi);
			}
			
			if (mix > 0) {
				hi--;
			} else {
				lo++;
			}
		}
		
		System.out.println(ansL+" "+ansR);
		
	}	

}
