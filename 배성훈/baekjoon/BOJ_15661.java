package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15661 {
    static int n;
    static int[][] arr;
    static int min=Integer.MAX_VALUE;
    static boolean[] team;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n+1][n+1];
        team=new boolean[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                arr[i][j]=sc.nextInt();
            }
            sc.nextLine();
        }
        play(1,0);
        System.out.println(min);
    }

    private static void play(int idx,int count){
        if(idx>n){
            if(count>0&&count<n){
                min=Math.min(min,calculate());
            }
            return;
        }
        team[idx]=true;
        play(idx+1,count+1);
        team[idx]=false;
        play(idx+1,count);
    }

    private static int calculate(){
        List<Integer> a=new ArrayList<>();
        List<Integer> b=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(team[i]){
                a.add(i);
            }else{
                b.add(i);
            }
        }
        int score1 = 0;
        int score2 = 0;
        for(int i=0;i<a.size();i++){
            for(int j=i+1;j<a.size();j++){
                score1+=arr[a.get(i)][a.get(j)]+arr[a.get(j)][a.get(i)];
            }
        }
        for(int i=0;i<b.size();i++){
            for(int j=i+1;j<b.size();j++){
                score2+=arr[b.get(i)][b.get(j)]+arr[b.get(j)][b.get(i)];
            }
        }
        return Math.abs(score1-score2);
    }
}
