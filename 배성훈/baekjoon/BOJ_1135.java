package baekjoon;

import java.io.IOException;
import java.util.*;
/*
 *
 *                               0
 *                             1
 *                           2
 *                          3
 *                         4
 *
 *
 *
 *
 * */
public class BOJ_1135 {
    static int[] dp;
    static int n;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        dp =new int[n];
        adj=new List[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int parent=sc.nextInt();
            if(parent!=-1){
                adj[parent].add(i);
            }
        }
        System.out.println(play(0));
    }

    private static int play(int idx){
        List<Integer> times=new ArrayList<>();
        for(int next:adj[idx]){
            times.add(play(next));
        }
        Collections.sort(times,Collections.reverseOrder());
        int maxTime=0;
        for(int i=0;i<times.size();i++){
            maxTime=Math.max(maxTime,times.get(i)+i+1);
        }
        return maxTime;
    }
}
