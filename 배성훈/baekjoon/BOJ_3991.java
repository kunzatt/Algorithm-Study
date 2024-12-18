import java.io.IOException;

class BOJ_3991 extends FI {
    public static void main(String[] args)throws IOException {
        initFI();
        int[] dy={0,1,0,-1};
        int[] dx={1,0,-1,0};

        int n=nextInt();
        int m=nextInt();
        int k=nextInt();
        int[][] arr=new int[n][m];
        int[] balls=new int[k+1];
        for(int i=1;i<=k;i++){
            balls[i]=nextInt();
        }
        int y=0,x=0,d=0,idx=1;
        arr[y][x]=idx;
        balls[idx]--;
        while(idx<=k){
            int ny=y+dy[d];
            int nx=x+dx[d];
            if(balls[idx]==0)idx++;

            if(ny<0||nx<0||ny>=n||nx>=m||arr[ny][nx]!=0){
                d=(d+1)%4;
                continue;
            }


            arr[ny][nx]=idx;
            balls[idx]--;
            y=ny;
            x=nx;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}