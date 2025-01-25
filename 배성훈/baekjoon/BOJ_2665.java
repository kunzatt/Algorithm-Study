package baekjoon;

import java.util.*;

public class BOJ_2665 {
    static int[] dy={-1,1,0,0};
    static int[] dx={0,0,-1,1};
    static int n;
    static int[][] arr;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        sc.nextLine();
        arr=new int[n][n];
        ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            String s=sc.nextLine();
            for(int j=0;j<n;j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,0});
        int[][] visited = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }
        while(!q.isEmpty()){
            int[] info=q.poll();
            int y=info[0];
            int x=info[1];
            int b=info[2];

            if(b>=visited[y][x])continue;
            visited[y][x]=b;

            if(y==n-1&&x==n-1){
                ans=Math.min(ans,b);
                continue;
            }
            for(int i=0;i<4;i++){
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(ny<0||nx<0||ny>=n||nx>=n)continue;
                if(arr[ny][nx]==1){
                    if(b<visited[ny][nx]){
                        q.add(new int[]{ny,nx,b});
                    }
                }else if(arr[ny][nx]==0){
                    if(b+1<visited[ny][nx]){
                        q.add(new int[]{ny,nx,b+1});
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
