import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14677 {
    static int N;
    static int[] medi;
    static boolean[][][] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        medi = new int[3*N];
        char[] tmp = br.readLine().toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i]=='B') medi[i]=0;
            if (tmp[i]=='L') medi[i]=1;
            if (tmp[i]=='D') medi[i]=2;
        }
        
        visited = new boolean[3][3*N][3*N];
        
        System.out.println(bfs());
    }
    
    private static int bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0, 0, 3*N-1});
        visited[0][0][3*N-1] = true;
        int max = 0;
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int time = cur[0];
            int left = cur[1];
            int right = cur[2];
            
            max = Math.max(max, time);
            
            if (left > right) continue;
            
            if (medi[left] == time%3) {
            	if (left==3*N-1) max = Math.max(max, time+1);
            	else if (!visited[(time+1)%3][left+1][right]) {
            		que.add(new int[] {time+1, left+1, right});
                	visited[(time+1)%3][left+1][right] = true;
            	}
            }
            
            if (medi[right] == time%3) {
            	if (right==0) max = Math.max(max, time+1);
            	else if (!visited[(time+1)%3][left][right-1]) {
                	que.add(new int[] {time+1, left, right-1});
                	visited[(time+1)%3][left][right-1] = true;
            	}
            }
        }
        
        return max;
    }
}
