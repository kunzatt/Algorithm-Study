package baekjoon;

import java.io.IOException;
import java.util.*;

/*

0  0  0  0  0  0  0
0  15 0  0  0  0  15
0  0  0  0  0  0  0
0  15 0  0  0  0  0
0  0  0  0  0  0  0
0  0  0  0  0  0  0

24
* */

public class BOJ_14585 {
    static int[] dy={0,1};
    static int[] dx={1,0};
    static int n,m;
    static int[][] arr;
    static List<int[]> list;
    static int[][] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        sc.nextLine();

        max=0;
        arr=new int[301][301];
        dp=new int[301][301];
        for(int i=0;i<=300;i++){
            Arrays.fill(dp[i],-1);
        }
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int y=sc.nextInt();
            int x=sc.nextInt();
            list.add(new int[]{y,x});
            arr[y][x]=m;
        }
        play(0,0,0,1);
        System.out.println(max);
    }

    private static void play(int y,int x,int total,int time){
        if(y==300&&x==300){
            max=Math.max(max,total);
            return;
        }
        if(dp[y][x]>=total){
            return;
        }
        dp[y][x]=total;
        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny > 300 || nx > 300) continue;
            int num=arr[ny][nx]-time;
            if(num<0)num=0;
            play(ny, nx,total+num,time+1);
        }
    }
}