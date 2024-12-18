import java.io.IOException;
import java.util.*;

// 17130. 토끼가 정보섬에 올라온 이유 / 골드 4 / 13:30~13:52
// bfs(dp)
class BOJ_17130 extends FI1 {
    public static void main(String[] args) throws IOException {
        initFI();
        final int[] dy={0,1,-1};
        final int[] dx={1,1,1};
        List<int[]> doors=new ArrayList<>();
        int n=nextInt();
        int m=nextInt();
        char[][] arr=new char[n][m];
        int y=0,x=0;
        for(int i=0;i<n;i++){
            String s=next();
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='R'){y=i;x=j;}
                if(s.charAt(j)=='O')doors.add(new int[]{i,j});
                arr[i][j]=s.charAt(j);
            }
        }
        int maxCnt=-1;
        int[][] count=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            Arrays.fill(count[i],-1);
        }
        count[y][x]=0;
        q.add(new int[]{y,x,0});
        while(!q.isEmpty()){
            int[] info=q.poll();
            y=info[0];
            x=info[1];
            int cnt=info[2];
            for(int i=0;i<3;i++){
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(ny<0||nx<0||ny>=n||nx>=m||arr[ny][nx]=='#')continue;
                if(arr[ny][nx]=='C'){
                    if(count[ny][nx]<count[y][x]+1){
                        count[ny][nx]=count[y][x]+1;
                        q.add(new int[]{ny,nx,cnt+1});
                    }
                }else{
                    if(count[ny][nx]<count[y][x]){
                        count[ny][nx]=count[y][x];
                        q.add(new int[]{ny,nx,cnt});
                    }
                }
            }
        }
        for(int[] d:doors){
            maxCnt=Math.max(count[d[0]][d[1]],maxCnt);
        }
        System.out.println(maxCnt);
    }
}