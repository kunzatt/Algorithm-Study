package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1139 {
    static int n;
    static int[] arr;
    static double[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        dp=new double[1<<n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.fill(dp,-1);
        double ans=play(0);
        System.out.println(ans);
    }

    private static double play(int state){
        if(Integer.bitCount(state)%3!=0){
            return 0;
        }
        if(dp[state]!=-1){
            return dp[state];
        }
        dp[state]=0;
        for(int i=0;i<n;i++){
            if((state&(1<<i))!=0)continue;
            for (int j=i+1; j<n;j++) {
                if((state&(1<<j))!=0)continue;
                for(int k=j+1;k<n;k++){
                    if((state&(1<<k))!=0)continue;
                    int next=state|(1<<i)|(1<<j)|(1<<k);
                    int[] t=new int[]{arr[i],arr[j],arr[k]};
                    if(isTriangle(t)){
                        double area=getArea(t);
                        dp[state]=Math.max(
                                dp[state],
                                area+play(next)
                        );
                    }
                }
            }
        }
        return dp[state];
    }

    private static boolean isTriangle(int[] t){
        return t[0]+t[1]>t[2]&&
                t[0]+t[2]>t[1]&&
                t[1]+t[2]>t[0];
    }

    private static double getArea(int[] t){
        double s=((double)t[0]+t[1]+t[2])/2.0;
        return Math.sqrt(s*(
                (s-t[0])*(s-t[1])*(s-t[2])
        ));
    }
}
