import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
[BOJ] 게임 / 골드 2 / 31분
 */
class BOJ_1103 {
    static int[] dy={-1,1,0,0};
    static int[] dx={0,0,-1,1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;
    static char[][] arr;
    static int[][] visited;
    static int maxMove;
    static boolean inf;

    public static void main(String[] args)throws IOException {
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new char[n][m];
        visited=new int[n][m];
        for(int i=0;i<n;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j);
            }
        }
        for(int[] v:visited)Arrays.fill(v,-1);
        play(0,0,1);
        System.out.println(inf?-1:maxMove);
    }

    private static void play(int y,int x,int move){
        if(inf)return;

        int d=arr[y][x]-'0';
        visited[y][x]=0;
        maxMove=Math.max(maxMove,move);

        for(int i=0;i<4;i++){
            int ny=y+(dy[i]*d);
            int nx=x+(dx[i]*d);
            if(ny<0||nx<0||ny>=n||nx>=m||arr[ny][nx]=='H'){
                continue;
            }
            if(visited[ny][nx]>=move+1){
                continue;
            }
            if(visited[ny][nx]==0){
                inf=true;
                return;
            }
            play(ny,nx,move+1);
        }
        visited[y][x]=move;
    }
}