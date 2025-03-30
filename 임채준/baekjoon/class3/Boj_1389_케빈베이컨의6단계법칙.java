package class3;

import java.io.*;
import java.util.*;

public class Boj_1389_케빈베이컨의6단계법칙 {
	
	static int N, M, a, b, minbnum, minper, sum;
	static int[] distance;
	
    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        minbnum = Integer.MAX_VALUE;
        minper = -1;
        
        for (int i = 1; i <= N; i++) {
            int bnum = bfs(graph, i);
            
            if (bnum < minbnum) {
                minbnum = bnum;
                minper = i;
            }
        }
        
        System.out.println(minper);
    }
    
    private static int bfs(ArrayList<Integer>[] graph, int start) {
        distance = new int[N + 1];
        Arrays.fill(distance, -1);
        
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        distance[start] = 0;
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            
            for (int next : graph[cur]) {
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    que.offer(next);
                }
            }
        }
        
        sum = 0;
        for (int i = 1; i <= N; i++) {
            if (i != start) {
                sum += distance[i];
            }
        }
        
        return sum;
    }
}