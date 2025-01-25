package baekjoon;

import java.util.*;

public class BOJ_17836 {
    static int[] dy={-1,1,0,0};
    static int[] dx={0,0,-1,1};
    static int n,m,t;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        t=sc.nextInt();
        arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        boolean[][][] visited=new boolean[n][m][2];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,0,0});
        visited[0][0][0]=true;
        while(!q.isEmpty()){
            int[] info=q.poll();
            int y=info[0];
            int x=info[1];
            int time=info[2];
            int g=info[3];
            if(time>t)continue;
            if(y==n-1&&x==m-1&&time<=t){
                System.out.println(time);
                return;
            }
            for(int i=0;i<4;i++){
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(ny<0||nx<0||ny>=n||nx>=m)continue;
                if(arr[ny][nx]==2&&!visited[ny][nx][1]){
                    visited[ny][nx][1]=true;
                    q.add(new int[]{ny,nx,time+1,1});
                }else if(arr[ny][nx]==0&&!visited[ny][nx][g]){
                    visited[ny][nx][g]=true;
                    q.add(new int[]{ny,nx,time+1,g});
                }else if(arr[ny][nx]==1){
                    if(g==1&&!visited[ny][nx][1]){
                        visited[ny][nx][1]=true;
                        q.add(new int[]{ny,nx,time+1,1});
                    }
                }
            }
        }
        System.out.println("Fail");
    }
}
