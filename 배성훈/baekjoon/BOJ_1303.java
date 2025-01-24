package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1303 {
    static final int[] dy={-1,1,0,0};
    static final int[] dx={0,0,-1,1};
    static Scanner sc=new Scanner(System.in);
    static int n,m;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) {
        int my=0;
        int enemy=0;
        m=sc.nextInt();
        n=sc.nextInt();
        sc.nextLine();
        arr=new char[n][m];
        visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLine().toCharArray();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    if(arr[i][j]=='W'){
                        my+=(int)Math.pow(dd(i,j,arr[i][j]),2);
                    }else{
                        enemy+=(int)Math.pow(dd(i,j,arr[i][j]),2);
                    }
                }
            }
        }
        System.out.println(my+" "+enemy);
    }

    private static int dd(int y,int x,char c){
        int count=1;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x]=true;
        while(!q.isEmpty()){
            int[] info=q.poll();
            y=info[0];
            x=info[1];
            for(int i=0;i<4;i++){
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(ny<0||nx<0||ny>=n||nx>=m||visited[ny][nx]||arr[ny][nx]!=c)continue;
                count++;
                visited[ny][nx]=true;
                q.add(new int[]{ny,nx});
            }
        }
        return count;
    }
}