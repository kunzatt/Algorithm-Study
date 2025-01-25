import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_2665 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node implements Comparable<Node> {
        int r, c, cnt;
        public Node(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String s = sc.next();
            for(int j=0; j<n; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        } // 입력 끝

        count = dijkstra();
        System.out.println(count);
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int dist = 0;
        pq.add(new Node(0,0,0));
        visited[0][0] = true;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(int d=0; d<4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                int nCnt = cur.cnt;
                if(!check(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(nc == n-1 && nr == n-1){
                    return nCnt;
                }
                if(map[nr][nc] == 0){
                    nCnt++;
                    //System.out.println(nr+" "+nc+" "+nCnt);
                }
                visited[nr][nc] = true;
                pq.add(new Node(nr, nc, nCnt));

            }
        }
        return dist;
    }

    private static boolean check(int r, int c){
        return r>=0 && r<n && c>=0 && c<n;
    }
}
