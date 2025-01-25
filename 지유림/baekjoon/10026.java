import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        // 적록색약 아님
        int normal = color(false);
        
        // 적록색약
        int colorBlind = color(true);
        
        System.out.println(normal + " " + colorBlind);
    }
    
    static int color(boolean isColorBlind) {
        visited = new boolean[N][N];
        int count = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, map[i][j], isColorBlind);
                    count++;
                }
            }
        }
        return count;
    }
    
    static void dfs(int r, int c, char color, boolean isColorBlind) {
        visited[r][c] = true;
        
        for(int d = 0; d < 4; d++) {
            int nr = r + drc[d][0];
            int nc = c + drc[d][1];
            
            if(!check(nr, nc) || visited[nr][nc]) continue;
            
            if(isColorBlind) {
                if((color == 'B' && map[nr][nc] == 'B') || 
                   (color != 'B' && map[nr][nc] != 'B')) {
                    dfs(nr, nc, color, true);
                }
            } else if(map[nr][nc] == color) {
                dfs(nr, nc, color, false);
            }
        }
    }
    
    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
