package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2234 {
    static int[] dy={0,-1,0,1};
    static int[] dx={-1,0,1,0};
    static int n,m;
    static int[][] arr;
    static boolean[][] visited;

    static int roomCnt,maxRoom;


    /*
    좌 1
    상 2
    우 4
    하 8
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        arr=new int[n][m];
        visited=new boolean[n][m];
        sc.nextLine();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
            sc.nextLine();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j])continue;

                play(i,j);
                roomCnt++;
            }
        }

        System.out.println(roomCnt);
        System.out.println(maxRoom);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited=new boolean[n][m];

                for(int k=0;k<4;k++){
                    if((arr[i][j]&(1<<k))==0)continue;
                    arr[i][j]&=~(1<<k);
                    play(i,j);
                    arr[i][j]|=(1<<k);
                }

            }
        }

        System.out.println(maxRoom);
    }

    private static void play(int y,int x){
        int count=0;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x]=true;

        while(!q.isEmpty()){
            int[] info=q.poll();
            y=info[0];
            x=info[1];
            count++;
            for(int i=0;i<4;i++){
                if((arr[y][x]&(1<<i))!=0)continue;
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(ny<0||nx<0||ny>=n||nx>=m||visited[ny][nx])continue;
                visited[ny][nx]=true;
                q.add(new int[]{ny,nx});
            }
        }
        maxRoom=Math.max(maxRoom,count);
    }
}
