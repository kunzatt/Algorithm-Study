import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static String S;
    static class State {
        int left, right, count;
        char now;
        
        public State(int left, int right, char now, int count) {
            this.left = left;
            this.right = right;
            this.now = now;
            this.count = count;
        }
    }
    
    static boolean[][][] visited; // 방문 여부를 3D 배열로 변경
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = br.readLine();
        
        int totalCount = 3 * N; // 총 약의 개수
        Queue<State> que = new LinkedList<>();
        visited = new boolean[totalCount + 1][totalCount + 1][3]; // 왼쪽, 오른쪽, 아침/점심/저녁

        que.offer(new State(0, totalCount - 1, 'B', 0)); // 초기 상태 설정

        bfs(que, S);
        System.out.println(max); // 최종 먹은 약의 수 출력
    }
    
    static void bfs(Queue<State> que, String m) {
        while (!que.isEmpty()) {
            State s = que.poll();
            max = Math.max(max, s.count);
            
            int left = s.left;
            int right = s.right;
            char now = s.now;
            
            // 왼쪽에서 약 먹는 경우
            if (left <= right && m.charAt(left) == now) {
                char next = nextMedicine(now); // 다음 약 고르기
                int num = getMedi(next);
                if (!visited[left + 1][right][num]) { // 방문 체크
                    visited[left + 1][right][num] = true; // 방문 처리
                    que.offer(new State(left + 1, right, next, s.count + 1));
                }
            }
            
            // 오른쪽에서 약 먹는 경우
            if (left <= right && m.charAt(right) == now) {
                char next = nextMedicine(now); // 다음 약 고르기
                int num = getMedi(next);
                if (!visited[left][right - 1][num]) { // 방문 체크
                    visited[left][right - 1][num] = true; // 방문 처리
                    que.offer(new State(left, right - 1, next, s.count + 1));
                }
            }
        }
    }

    // 다음 약 고르는 함수
    static char nextMedicine(char now) {
        if (now == 'B') return 'L';
        if (now == 'L') return 'D';
        if (now == 'D') return 'B';
        return 'B'; // 기본값
    }
    
    
    static int getMedi(char now) {
        if (now == 'B') return 0;
        if (now == 'L') return 1;
        if (now == 'D') return 2;
        return -1; // 잘못된 경우
    }
}
