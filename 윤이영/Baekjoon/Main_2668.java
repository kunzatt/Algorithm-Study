import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main_2668 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static int count;
	static ArrayList<Integer> c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		visited = new boolean[N+1];
		c = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {
			//System.out.println(i);
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
			//System.out.println(Arrays.toString(visited));
		}
		
		System.out.println(count);
		Collections.sort(c);
		for(int i:c) {
			System.out.println(i);
		}
	}
	
	private static void dfs(int start, int target) {
		int next = arr[start];
		if(visited[next] == false) {
			visited[next] = true;
			dfs(next, target);
			visited[next] = false;
		}
		
		if(arr[start] == target) {
			c.add(start); 
			count++;
		}
	}
}