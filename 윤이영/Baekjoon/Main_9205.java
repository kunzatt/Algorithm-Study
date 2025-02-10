import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205 {
    static int t, n;
    static List<int[]> list;
    static int[] strt, end;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<t; tc++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<int[]>();
            strt = new int[2];
            end = new int[2];
            for(int i=0; i<n+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(i == 0) {	// 상근이 집 (시작점)
                    strt[0] = x;
                    strt[1] = y;
                }
                else if(i == n+1) {	//  락페스티벌 (도착점)
                    end[0] = x;
                    end[1] = y;
                }
                else list.add(new int[] {x, y});	// 편의점
            }

            if(bfs()) {
                System.out.println("happy");
            } else System.out.println("sad");
        }
    }

    private static boolean bfs() {
        Queue<int []> que = new LinkedList<int[]>();
        boolean[] visited = new boolean[n];
        que.add(strt);	// 시작점을 큐에 넣기

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            // System.out.println(cur[0]+" "+cur[1]);
            if(Manhattan(cur, end)) { // 목적지까지 맨하탄 거리 1000이하일 경우 true 반환
                return true;
            }
            for(int i=0; i<n; i++) {	// list안에 들어있는 값을 순회(편의점)
                if(!visited[i]) {	// 방문하지 않은 곳일 경우
                    int[] next = list.get(i);	// 다음 목적지로 설정
                    if(Manhattan(cur, next)) {	// 맨하탄 거리상 갈 수 있는 곳인지 판별
                        que.add(next);
                        visited[i] = true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean Manhattan(int[] cur, int[] next) {
        return Math.abs(cur[0]-next[0]) + Math.abs(cur[1]-next[1]) <= 1000;
    }
}
