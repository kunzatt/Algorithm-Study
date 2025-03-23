import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    static char[][] map;
    static boolean[] visited = new boolean[26]; // 알파벳 방문 여부 (A~Z)
    static int maxCount = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        

        visited[map[0][0] - 'A'] = true; // 첫 번째 알파벳 방문 표시
        dfs(0, 0, 1);
        
        System.out.println(maxCount);
    }
    
   
    
    static void dfs(int r, int c, int count) {
        // 현재까지의 이동 횟수가 최대값보다 크면 갱신
        maxCount = Math.max(maxCount, count);
        
        // 네 방향으로 이동 시도
        for (int d = 0; d < 4; d++) {
            int nr = r + drc[d][0];
            int nc = c + drc[d][1];
            
            if (check(nr, nc)) {
                // 새로운 위치의 알파벳 인덱스
                int alphabetIndex = map[nr][nc] - 'A';
                
                // 아직 방문하지 않은 알파벳이라면
                if (!visited[alphabetIndex]) {
                    visited[alphabetIndex] = true; 
                    dfs(nr, nc, count + 1);     
                    visited[alphabetIndex] = false; // 백트래킹 (방문 표시 제거)
                }
            }
        }
    }
    
     static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
