import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16948 {
    static int[] dr={-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};
    static int[][] map;
    static int[][] visited;
    static int N;
    static int r1, c1, r2, c2;
    static int ans = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new int[N][N];
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        ans = bfs(r1, c1);

        System.out.println(ans);

    }

    private static int bfs(int r1, int c1){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {r1, c1, 0});
        visited[r1][c1] = 0;

        while(!que.isEmpty()){
            int cur[] = que.poll();
            int dist = cur[2];
            //System.out.println(cur[0]+" "+cur[1]+" :"+dist);

            if(cur[0] == r2 && cur[1] == c2){
                return dist;
            }
            for(int d=0; d<6; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(!check(nr, nc)) continue;
                if(visited[nr][nc] == 0){
                    que.add(new int[] {nr, nc, dist+1});
                    visited[nr][nc] = dist+1;
                }
            }
        }

        return -1;
    }


    static boolean check(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}
