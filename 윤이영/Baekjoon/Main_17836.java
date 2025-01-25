import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17836 {
    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node {
        int r, c, time; 
        boolean gram;
        public Node (int r, int c, int time, boolean gram) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.gram = gram;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];	// 검이 있을 때와 없을 떄

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = bfs();
        if(ans == -1){
            System.out.println("Fail");
        }
        else{
            System.out.println(ans);
        }
    }

    private static int bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0, false));
        visited[0][0][0] = true;

        while(!que.isEmpty()){
            Node cur = que.poll();
            if(cur.time > T) break;
            if(cur.r == N-1 && cur.c == M-1) return cur.time;
            
            for(int d=0; d<4; d++){
                int nr = cur.r+dr[d];
                int nc = cur.c+dc[d];
                if(!check(nr, nc)) continue;
                // 그람이 없는 경우
                if(!cur.gram) {
                	if(visited[nr][nc][0]) continue;
                	if(map[nr][nc] == 0) {
                		visited[nr][nc][0] = true;
                		que.add(new Node(nr,nc, cur.time+1, cur.gram));
                	}
                	else if(map[nr][nc] == 2) {
                		visited[nr][nc][0] = true;
                		que.add(new Node(nr, nc, cur.time+1, true));
                	}
                }
                // 그람이 있는 경우
                else {
                	if(!visited[nr][nc][1]) {
                		que.add(new Node(nr, nc, cur.time+1, cur.gram));
                		visited[nr][nc][1] = true;
                	}
                }
            }
        }
        return -1;
    }

    private static boolean check(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}
