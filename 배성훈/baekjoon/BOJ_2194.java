package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2194 {
    static int[] dy={-1,1,0,0};
    static int[] dx={0,0,-1,1};
    static int n,m,a,b,k;
    static int sy,sx;
    static int ey,ex;

    static boolean[][] wall;



    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        wall=new boolean[n+1][m+1];
        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            wall[y][x]=true;
        }
        st=new StringTokenizer(br.readLine());
        sy=Integer.parseInt(st.nextToken());
        sx=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        ey=Integer.parseInt(st.nextToken());
        ex=Integer.parseInt(st.nextToken());


        System.out.println(play());

    }

    private static int play(){
        boolean[][] visited=new boolean[n+1][m+1];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sy,sx,0});
        visited[sy][sx]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int y=cur[0];
            int x=cur[1];
            int dist=cur[2];
            if(y==ey&&x==ex)return dist;

            for(int i=0;i<4;i++){
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(ny<1||nx<1||ny+a-1>n||nx+b-1>m)continue;
                if(visited[ny][nx])continue;
                if(!canMove(ny,nx))continue;

                q.add(new int[]{ny,nx,dist+1});
                visited[ny][nx]=true;
            }
        }

        return -1;
    }

    private static boolean canMove(int y,int x){
        for(int i=y;i<y+a;i++){
            for(int j=x;j<x+b;j++){
                if(wall[i][j])return false;
            }
        }
        return true;
    }
}
