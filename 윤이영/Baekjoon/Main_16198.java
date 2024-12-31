import java.util.ArrayList;
import java.util.Scanner;

public class Main_16198 {
	static int N;
	static ArrayList<Integer> energy;
	static int ans = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		energy = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			energy.add(sc.nextInt());
		}
		
		dfs(0);
		
		System.out.println(ans);
		
	}

	private static void dfs(int total) {
		if(energy.size() == 2) {
			ans = Math.max(total, ans);
			return;
		}
		
		for(int i=1; i<energy.size()-1; i++) {
			int s = energy.get(i-1) * energy.get(i+1);
			int tmp = energy.get(i);
			energy.remove(i);
			dfs(total +s);
			energy.add(i, tmp);
		}
		
		return;
	}


}
