import java.io.*;
import java.util.*;

// root가 node배열의 0번 인덱스 외에도 위치할 수 있다.
public class Main_1068 {
	
	static int N, K, count;
    static int[] node; 
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        node = new int[N];
        int root = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            node[i] = Integer.parseInt(st.nextToken());        
            if(node[i] == -1) root = i;
        }
        K = Integer.parseInt(br.readLine());
        
        dfs(K);
            
        count = 0;
        visited = new boolean[N];
        sol(root);
            
        System.out.println(count); 
    }
    
    public static void dfs(int n) {
    	
        node[n] = -10;
        
        for(int i = 0; i < n; i++) {
            if(node[i] == n) {
                dfs(i);
            }
        }
    }
    
    public static void sol(int num) {
    	
        boolean check = true;
        visited[num] = true;
        
        if(node[num] != -10) {
            for(int i = 0; i < N; i++) {
                if(node[i] == num && visited[i] == false) {
                    sol(i);
                    check = false;
                }
            }
            if(check) count++;
        }
    }
}

