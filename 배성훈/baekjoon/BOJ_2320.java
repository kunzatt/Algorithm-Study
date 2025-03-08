package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2320 {
    static int n;
    static String[] words;
    static int[][] dp;
    static final int INF=Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        sc.nextLine();
        words=new String[n];
        dp=new int[n][1<<n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            words[i]=sc.nextLine();
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,play(-1,i,1<<i));
        }
        System.out.println(ans);
    }

    private static int play(int prev,int cur,int state){
        if(prev!=-1&&words[prev].charAt(words[prev].length()-1)!=words[cur].charAt(0))return 0;
        if(dp[cur][state]!=-1)return dp[cur][state];
        dp[cur][state]=words[cur].length();
        for(int i=0;i<n;i++){
            if((state&(1<<i))!=0)continue;
            int next=state|(1<<i);
            dp[cur][state]=Math.max(
                    dp[cur][state],
                    words[cur].length()+play(cur,i,next)
            );
        }
        return dp[cur][state];
    }
}
