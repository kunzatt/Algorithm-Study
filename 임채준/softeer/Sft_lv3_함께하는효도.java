package sft;
import java.io.*;
import java.util.*;

public class Sft_lv3_함께하는효도 {
	
    static int n, m;
    static int[][] map;
    static Position[] friends;
    static boolean[][] visited;
    static int max = 0;
    static int[] dx = {-1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static class State {
        Position[] positions;
        boolean[][] harvested;
        int sum;
        
        State(Position[] positions, boolean[][] harvested, int sum) {
            this.positions = new Position[positions.length];
            for (int i = 0; i < positions.length; i++) {
                this.positions[i] = new Position(positions[i].x, positions[i].y);
            }
            this.harvested = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                this.harvested[i] = harvested[i].clone();
            }
            this.sum = sum;
        }
    }
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());       
        map = new int[n][n];
        friends = new Position[m];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            friends[i] = new Position(x, y);
        }
        
        boolean[][] harvested = new boolean[n][n];
        int initialSum = 0;
        for (Position friend : friends) {
            if (!harvested[friend.x][friend.y]) {
                initialSum += map[friend.x][friend.y];
                harvested[friend.x][friend.y] = true;
            }
        }
        
        dfs(0, new State(friends, harvested, initialSum));
        
        System.out.println(max);
    }
    
    static void dfs(int time, State state) {
        if (time == 3) {
            max = Math.max(max, state.sum);
            return;
        }
        
        // 각 친구별로 가능한 모든 이동 조합을 시도
        ArrayList<Position[]> nextPositions = new ArrayList<>();
        generateNextPositions(0, state.positions.clone(), nextPositions);
        
        for (Position[] next : nextPositions) {
            // 다음 위치들이 서로 겹치지 않는지 확인
            if (isValidMove(next)) {
                State nextState = new State(next, state.harvested, state.sum);
                // 새로운 위치에서 수확
                for (Position pos : next) {
                    if (!nextState.harvested[pos.x][pos.y]) {
                        nextState.sum += map[pos.x][pos.y];
                        nextState.harvested[pos.x][pos.y] = true;
                    }
                }
                dfs(time + 1, nextState);
            }
        }
    }
    
    static void generateNextPositions(int index, Position[] current, ArrayList<Position[]> result) {
        if (index == m) {
            result.add(current.clone());
            return;
        }
        
        Position pos = current[index];
        for (int i = 0; i < 4; i++) {
            int nx = pos.x + dx[i];
            int ny = pos.y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                Position original = current[index];
                current[index] = new Position(nx, ny);
                generateNextPositions(index + 1, current, result);
                current[index] = original;
            }
        }
    }
    
    static boolean isValidMove(Position[] positions) {
        // 같은 시간에 같은 위치에 있는지 확인
        for (int i = 0; i < positions.length; i++) {
            for (int j = i + 1; j < positions.length; j++) {
                if (positions[i].x == positions[j].x && positions[i].y == positions[j].y) {
                    return false;
                }
            }
        }
        return true;
    }
}