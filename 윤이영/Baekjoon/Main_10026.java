import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main_10026 {
    static int N;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] visited_rg;
    static int ans=0;
    static int ans_rg=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        visited_rg = new boolean[N][N];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }   // 입력 끝

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                // 방문하지 않은 구역이라면 bfs를 이용해서 방문 표시
                if(!visited[i][j]){
                    // System.out.println(i+" "+ j);
                    bfs(i, j);
                    ans++;
                }
                if(!visited_rg[i][j]){
                    bfs_rg(i, j);
                    ans_rg++;
                }
            }
        }

        System.out.println(ans+" "+ans_rg);
    }

    private static void bfs(int sr, int sc) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int d=0; d<4; d++){
                int nr = cur[0]+dr[d];
                int nc = cur[1]+dc[d];
                if(!check(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == map[cur[0]][cur[1]]){
                    que.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

    static void bfs_rg(int sr, int sc){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {sr, sc});
        visited_rg[sr][sc] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();

            for(int d=0; d<4; d++){
                int nr = cur[0]+dr[d];
                int nc = cur[1]+dc[d];

                if(!check(nr, nc)) continue;
                if(visited_rg[nr][nc]) continue;
                if(map[sr][sc] != 'B' && map[nr][nc] != 'B'){
                    que.add(new int[] {nr, nc});
                    visited_rg[nr][nc] = true;
                }
                else{
                    if(map[sr][sc]== map[nr][nc] ){
                        que.add(new int[] {nr, nc});
                        visited_rg[nr][nc] = true;
                    }
                }

            }
        }
    }

    static boolean check(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

}
