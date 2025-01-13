package baekjoon;

import java.util.*;

// 29
public class BOJ_2668 {
    static int[] arr;
    static int n;
    static boolean[] visited;
    static int[] size;
    static List<Integer> res=new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1];
        size=new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i=1;i<=n;i++){
            visited=new boolean[n+1];
            visited[i]=true;
            play(i,arr[i]);
        }
        System.out.println(res.size());
        for(int i:res){
            System.out.println(i);
        }
    }

    private static void play(int start,int idx){
        if(visited[idx]){
            if(start==idx){
                res.add(idx);
            }
            return;
        }
        visited[idx]=true;
        play(start,arr[idx]);
    }
}
