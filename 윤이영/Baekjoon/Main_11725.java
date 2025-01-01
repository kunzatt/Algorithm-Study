import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11725 {
	static int N;
	static ArrayList<Integer>[] tree;
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		tree = new ArrayList[N+1];
		parent = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			tree[i] = new ArrayList<>();
		}
	
		for(int i=1; i<N; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		
		// DFS를 이용한 방법
		// 1번이 루트 노트
		parent[1] = 1;
		Queue<Integer> que = new LinkedList<>();
		que.add(1);
		
		while(!que.isEmpty()) {
			int cur = que.poll();	// 현재 노드 설정
			for(int ch : tree[cur]) {
				// 현재 노드와 연결되어 있는 자식 노드들을 모두 탐색하면서 부모 노드가 기록되어 있지 않은 경우 업데이트
				if(parent[ch] == 0) {
					parent[ch] = cur;
					que.add(ch);
				}
			}
		}
		
		for(int i=2; i<=N; i++) {
			System.out.println(parent[i]);
		}
		
	}
	
}
