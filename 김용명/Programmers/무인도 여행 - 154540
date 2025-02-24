import java.util.*;

class Solution {
    
    static int n, m;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>(); 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    list.add(bfs(maps, i, j));
                }
            }
        }

        if (list.isEmpty()) return new int[]{-1};

        Collections.sort(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
    
    private int bfs(String[] maps, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        int sum = maps[r].charAt(c) - '0';

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && maps[nr].charAt(nc) != 'X') {
                    visited[nr][nc] = true;
                    sum += maps[nr].charAt(nc) - '0';
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return sum;
    }
}
