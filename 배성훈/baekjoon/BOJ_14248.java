package baekjoon;

import java.util.Scanner;

public class BOJ_14248 {
    static int n;
    static int[] arr;
    static int start;
    static boolean[] visited;
    static int max=0;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        sc.nextLine();
        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.nextLine();
        start=sc.nextInt();
        visited=new boolean[n];
        play(start-1,1);
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i])count++;
        }
        System.out.println(count);
    }

    private static void play(int idx,int count){
        max=Math.max(max,count);
        visited[idx]=true;
        if(idx-arr[idx]>=0&&!visited[idx-arr[idx]])play(idx-arr[idx],count+1);
        if(idx+arr[idx]<n&&!visited[idx+arr[idx]])play(idx+arr[idx],count+1);
    }
}
