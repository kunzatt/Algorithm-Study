package noclass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj_2668_숫자고르기 {

    static int N;
    static int[][] nums;
    static boolean[] visited;	
    static ArrayList<Integer> result;
    static int start;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[2][N];
        result = new ArrayList<>();

        for(int i = 0; i < N; i++){
            nums[0][i] = i + 1;
            nums[1][i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            start = i + 1;
            dfs(i);
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(result);
        sb.append(result.size()).append("\n");
        for(int num : result) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int cur) {
        if(visited[cur]) {
            if(nums[0][cur] == start) {
                add(cur);
            }
            return;
        }

        visited[cur] = true;
        int next = nums[1][cur] - 1;
        dfs(next);
    }

    static void add(int cur) {
        if(!result.contains(nums[0][cur])) {
            result.add(nums[0][cur]);
        }
        int next = nums[1][cur] - 1;
        if(nums[0][next] != start) {
            add(next);
        }
    }
}