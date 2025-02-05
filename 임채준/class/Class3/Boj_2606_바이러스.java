package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2606_바이러스 {
	
	static int N, M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int count = 0;
    
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        
        for(int i = 0; i < M; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
//        index: 0 -> [] (사용 안함)
//        index: 1 -> [2, 5]       // 1번 컴퓨터는 2, 5번과 연결
//        index: 2 -> [1, 3, 5]    // 2번 컴퓨터는 1, 3, 5번과 연결
//        index: 3 -> [2]          // 3번 컴퓨터는 2번과 연결
//        index: 4 -> [7]          // 4번 컴퓨터는 7번과 연결
//        index: 5 -> [1, 2, 6]    // 5번 컴퓨터는 1, 2, 6번과 연결
//        index: 6 -> [5]          // 6번 컴퓨터는 5번과 연결
//        index: 7 -> [4]
        
        dfs(1);
        
        System.out.println(count - 1);
       
    }
    
    static void dfs(int node) {
        visited[node] = true;
        count++;
        
        for(int next : graph.get(node)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}