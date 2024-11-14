import java.util.Scanner;

public class Main_10819 {
	static int[] arr;
	static int[] selected;
	static boolean[] visited;
	static int N;
	static int maxsum=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		arr = new int[N];
		selected = new int[N];
		visited=new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Perm(0);
		System.out.println(maxsum);
	}
	
	private static void Perm(int depth) {
		if(depth == N) {
			int sum = getsum();
			maxsum = Math.max(maxsum, sum);
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[depth] = arr[i];
			Perm(depth+1);
			visited[i] = false;
		}
		
	}

	private static int getsum() {
		int sum = 0;
		
		for(int i=0; i<N-1; i++) {
			sum += Math.abs(selected[i]-selected[i+1]);
		}
		return sum;
	}
}
