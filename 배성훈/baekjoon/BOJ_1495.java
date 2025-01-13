package baekjoon;

import java.util.Scanner;

// 70
public class BOJ_1495 {
    static Scanner sc=new Scanner(System.in);
    static int n,s,m;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) {
        n=sc.nextInt();
        s=sc.nextInt();
        m=sc.nextInt();
        arr=new int[n];
        dp=new boolean[n+1][m+1];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        dp[0][s]=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<=m;j++){
                if(!dp[i][j])continue;
                if(j+arr[i]<=m){
                    dp[i+1][j+arr[i]]=true;
                }
                if(j-arr[i]>=0){
                    dp[i+1][j-arr[i]]=true;
                }
            }
        }
        int max=-1;
        for(int j=0;j<=m;j++){
            if(dp[n][j]){
                max=Math.max(max,j);
            }
        }
        System.out.println(max);
    }
}