package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_8972 {
    static int[] dy={0,1,1,1,0,0,0,-1,-1,-1};
    static int[] dx={0,-1,0,1,-1,0,1,-1,0,1};
    static int n,m;
    static char[][] arr;
    static int y,x;
    static List<int[]> ard;
    static int[] command;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new char[n][m];
        ard =new ArrayList<>();
        for(int i=0;i<n;i++){
            String s=br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j]=s.charAt(j);
                if(arr[i][j]=='R'){
                    ard.add(new int[]{i,j});
                }else if(arr[i][j]=='I'){
                    y=i;x=j;
                }
            }
        }
        String s=br.readLine();
        command=new int[s.length()];
        for(int i=0;i<s.length();i++){
            command[i]=s.charAt(i)-'0';
        }
        play();
    }

    private static void play(){
        int move=0;

        for(int idx=0;idx<command.length;idx++){
            move++;
            int ny=y+dy[command[idx]];
            int nx=x+dx[command[idx]];
            if(arr[ny][nx]=='R'){
                System.out.println("kraj "+move);
                return;
            }
            arr[y][x]='.';
            arr[ny][nx]='I';
            y=ny;x=nx;

            int[][] next=new int[n][m];
            List<int[]>newArd=new ArrayList<>();
            for(int[] info:ard){
                int min=Integer.MAX_VALUE;
                int nry=-1,nrx=-1;
                for(int d=1;d<=9;d++){
                    int ry=info[0]+dy[d];
                    int rx=info[1]+dx[d];
                    if(ry<0||rx<0||ry>=n||rx>=m)continue;
                    int dist=Math.abs(y-ry)+Math.abs(x-rx);
                    if(min>dist){
                        min=dist;
                        nry=ry;
                        nrx=rx;
                    }
                }
                if(nry==y&&nrx==x){
                    System.out.println("kraj "+move);
                    return;
                }
                next[nry][nrx]++;
                newArd.add(new int[]{nry,nrx});
            }
            for(int[] info:ard){
                arr[info[0]][info[1]]='.';
            }
            ard.clear();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(next[i][j]==1){
                        arr[i][j]='R';
                        ard.add(new int[]{i,j});
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
