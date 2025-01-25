package baekjoon;

import java.util.Scanner;

//10분
public class BOJ_16938 {
    static final int MAX=(int)1e+9;
    static int[] arr;
    static int n,l,r,x;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        l=sc.nextInt();
        r=sc.nextInt();
        x=sc.nextInt();
        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        play(0,MAX,0,0,0);
        System.out.println(count);
    }

    private static void play(int idx,int min,int max,int total,int cnt){
        if(idx==n){
            if(cnt>=2&&max-min>=x&&l<=total&&total<=r){
                count++;
            }
            return;
        }
        play(idx+1,Math.min(arr[idx],min),Math.max(arr[idx],max),total+arr[idx],cnt+1);
        play(idx+1,min,max,total,cnt);
    }
}
