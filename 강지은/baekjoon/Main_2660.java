import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2660 {

    static int N, min, max;
    static ArrayList<Integer>[] adj;
    static List<Integer> nomi;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        nomi = new ArrayList<>();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == -1 && B == -1) break;

            adj[A].add(B);
            adj[B].add(A);
        }

        min = 51;
        for (int i = 1; i < N + 1; i++) {
            int cnt = find(i);
            if (min == cnt) {
                nomi.add(i);
            } else if (min > cnt) {
                min = cnt;
                nomi.clear();
                nomi.add(i);
            }
        }

        Collections.sort(nomi);
        System.out.println(min + " " + nomi.size());
        for (int i = 0; i < nomi.size(); i++) {
            System.out.print(nomi.get(i) + " ");
        }

    }

    private static int find(int start) {
        Queue<int[]> que = new LinkedList<>();
        visit = new boolean[N + 1];
        visit[start] = true;
        que.add(new int[]{start, 0});

        int max = 0;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int member = cur[0];
            int cnt = cur[1];

            max = Math.max(max, cnt);

            for (int i = 0; i < adj[member].size(); i++) {
                int friend = adj[member].get(i);

                if (visit[friend]) continue;
                visit[friend] = true;
                que.add(new int[]{friend, cnt + 1});
            }
        }

        return max;
    }


}
