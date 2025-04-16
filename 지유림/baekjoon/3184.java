import java.io.*;
import java.util.*;

class Main {
    static int R, C, totalSheep, totalWolf;
    static char[][] map;
    static boolean[][] visited;
    static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        visited = new boolean[R][C];
        
        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }       
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(!visited[i][j] && map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(totalSheep + " " + totalWolf);
    }
    
    static void bfs(int startR, int startC) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{startR, startC});
        visited[startR][startC] = true;
        
        int sheep = 0;
        int wolf = 0;
        
        while(!que.isEmpty()) {
            int[] curr = que.poll();
            int r = curr[0];
            int c = curr[1];
            
            if(map[r][c] == 'o') sheep++;
            else if(map[r][c] == 'v') wolf++;
            
            for(int d = 0; d < 4; d++) {
                int nr = r + drc[d][0];
                int nc = c + drc[d][1];
                
                if(!check(nr, nc) || visited[nr][nc] || map[nr][nc] == '#') continue;
                
                que.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
                
            }
        }
        
        if(sheep > wolf) {
            totalSheep += sheep;
        } else {
            totalWolf += wolf;
        }
    }
    
    static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
