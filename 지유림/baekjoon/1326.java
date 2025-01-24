import java.util.*;
import java.io.*;

public class Main1326_폴짝폴짝 {
    static int N;
    static int[] arr;
    static int[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            visited[i] = -1;
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;

        System.out.println(bfs(a, b));

    }

    static int bfs(int a, int b) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(a);
        visited[a] = 0;

        while(!que.isEmpty()) {
            int num = que.poll();
            int jump = arr[num];

            // 앞으로 점프 (배수 만큼)
            for(int d = 1; num + jump * d < N; d++) {
                int dd = num+jump*d;
                if(visited[dd] == -1) {
                    visited[dd] = visited[num]+1;
                    que.offer(dd);
                }
            }

            // 뒤로 점프
            for(int d = 1; num - jump * d >= 0; d++) {
                int dd = num-jump*d;
                if(visited[dd] == -1) {
                    visited[dd] = visited[num]+1;
                    que.offer(dd);
                }
            }
        }

        return visited[b];
    }
}
