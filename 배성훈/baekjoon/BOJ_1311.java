package baekjoon;

import java.util.*;

// 비트dp 80분
public class BOJ_1311 {
    static final int INF=1234567891;
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long[][] arr;
    static long[][] dp;
    static int full;

    public static void main(String[] args) {
        n=sc.nextInt();
        full=(1<<n)-1;
        arr=new long[n][n];
        dp=new long[n][full];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(play(0,0));
    }

    private static long play(int cur,int visited){
        if(cur==n){
            return 0;
        }
        if(dp[cur][visited]!=-1){
            return dp[cur][visited];
        }
        dp[cur][visited]=INF;

        for(int next=0;next<n;next++){
            if((visited&(1<<next))==0){
                dp[cur][visited]=Math.min(
                        play(cur+1,visited|(1<<next))+arr[cur][next],
                        dp[cur][visited]
                );
            }
        }
        return dp[cur][visited];
    }
}