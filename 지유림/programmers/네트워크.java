class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        int networkCount = 0;
        
        for(int i = 0; i < n; i++) {
            // 아직 방문 안했으면 dfs
            if(!visited[i]) {
                dfs(computers, visited, i);
                networkCount++;
            }
        }
        
        
        return networkCount;
    }
    
    void dfs(int[][] computers, boolean[] visited, int current) {
        visited[current] = true;
        
        for(int i = 0; i < computers.length; i++) {
            if(visited[i]) continue;
            
            if(computers[current][i] == 1) {
                dfs(computers, visited, i);
            }
        }
    }
}
