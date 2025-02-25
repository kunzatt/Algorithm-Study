import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404 {
    static int n, m;
    static int a, b, c;
    static int[][] map;
    static int INF = 10000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j] =INF;
            }
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);
        }

        for(int k=1; k<=n; k++){ //  경유
            for(int i=1; i<=n; i++){ // 출발
                for(int j=1;j<=n; j++){  // 도착
                    if(i == j){
                        continue;
                    }
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j] >= INF){
                    map[i][j]= 0;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
