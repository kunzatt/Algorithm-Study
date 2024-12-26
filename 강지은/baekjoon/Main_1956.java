import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1956 {
    static int V, E;
    static int[][] dist;
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[V][V];
        
        for (int r = 0; r < V; r++) {
			for (int c = 0; c < V; c++) {
				dist[r][c] = INF;
			}
		}
        
        for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			dist[a][b] = c;
		}
        
        for (int k = 0; k < V; k++) {
			for (int r = 0; r < V; r++) {
				for (int c = 0; c < V; c++) {
					if (dist[r][k]==INF && dist[k][c]==INF) continue;
					dist[r][c] = Math.min(dist[r][c], dist[r][k]+dist[k][c]);
				}
			}
		}
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
        	if (dist[i][i]==INF) continue;
			min = Math.min(min, dist[i][i]);
		}
        
        if (min==Integer.MAX_VALUE) {
        	System.out.println(-1);
        } else {
        	System.out.println(min);
        }
        
    }
    
}
