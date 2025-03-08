package baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_16991 {
    static int n;
    static List<int[]> cities;
    static double[][] dp;
    static double INF=Double.MAX_VALUE/2;

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        cities=new ArrayList<>();
        dp=new double[n][1<<n];
        for(int i=0;i<n;i++){
            cities.add(new int[]{sc.nextInt(),sc.nextInt()});
        }
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(play(0,0,1));
    }

    private static double play(int start,int cur,int state){
        if(state==(1<<n)-1){
            return getDistance(
                    cities.get(cur)[0],cities.get(cur)[1],
                    cities.get(start)[0],cities.get(start)[1]
            );
        }
        if(dp[cur][state]!=-1)return dp[cur][state];
        dp[cur][state]=INF;
        int[] city1=cities.get(cur);
        for(int i=0;i<n;i++){
            if((state&(1<<i))!=0)continue;
            int next=state|(1<<i);
            int[] city2=cities.get(i);
            double dist=getDistance(city1[0],city1[1],city2[0],city2[1]);
            dp[cur][state]=Math.min(
                    dp[cur][state],
                    dist+play(start,i,next)
            );
        }
        return dp[cur][state];
    }

    private static double getDistance(int y1,int x1,int y2,int x2){
        return Math.sqrt(
                Math.pow((y2-y1),2)
                        +Math.pow((x2-x1),2)
        );
    }
}
