import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {
    static int N, M;
    static int[][] map;
    static int[][] temp;
    static boolean[][] visited;
    static boolean[] ans;
    static ArrayList<int[]> empty = new ArrayList<>();
    static ArrayList<int[]> virus = new ArrayList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int maxcnt = 0;
    static int v = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) {
                    empty.add(new int[] {i, j});
                    v++;
                }
                if(map[i][j] == 2) {
                    virus.add(new int[] {i, j});
                }
            }
        }
        
        
        // 1. 벽을 3개 세운다. (조합)
        nCr(0, 0);
        
        System.out.println(maxcnt);
    }

    private static void nCr(int depth, int start) {
        if(depth == 3) {
        	// 2. 벽을 세운 후 BFS로 바이러스 퍼뜨리기
            maxcnt = Math.max(maxcnt, bfs());
            return;
        }
        
        for(int i=start; i<empty.size(); i++) {
            int[] cur = empty.get(i);
            map[cur[0]][cur[1]] = 1;
            nCr(depth+1, i+1);    // 뽑음
            map[cur[0]][cur[1]] = 0;
        }
        
    }

    private static int bfs() {
        int count = 0;
        temp = new int[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.addAll(virus);
        for(int i=0; i<virus.size(); i++) {
        	temp[virus.get(i)[0]][virus.get(i)[1]] = 2;
        }
        
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                
                if(!check(nr, nc)) continue;
                if(temp[nr][nc] == 0 && map[nr][nc] == 0) {
                    temp[nr][nc] = 2;
                    que.add(new int[] {nr, nc});
                }
            }
        }
        
        //print(temp);
        
        // 3. 안전영역 세기
        for(int r=0; r<N; r++) {
        	for(int c=0; c<M; c++) {
        		if(temp[r][c] == 0 && map[r][c] != 1) {
        			count++;
        		}
        	}
        }
        return count;
    }

    private static boolean check(int r, int c) {
        // TODO Auto-generated method stub
        return r>= 0 && r<N && c>=0 && c<M;
    }

    private static void print(int[][] map) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("----------------------------------");
    }


}
