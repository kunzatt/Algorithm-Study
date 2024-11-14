import java.io.IOException;

// 10164. 격자상의 경로 / 실버2 / 23분
public class BOJ_10164 extends FI1 {
    static int n,m,k;

    public static void main(String[] args) throws IOException {
        initFI();
        n=nextInt();
        m=nextInt();
        k=nextInt();
        if(k==0){
            System.out.println(dfs(0,0,n-1,m-1));
        }else{
            k--;
            System.out.println(dfs(0,0,k/m,k%m)*dfs(k/m,k%m,n-1,m-1));
        }
    }

    private static int dfs(int y,int x,int ey,int ex){
        if(y>ey||x>ex)return 0;
        if(y==ey&&x==ex)return 1;

        int res=0;
        res+=dfs(y+1,x,ey,ex);
        res+=dfs(y,x+1,ey,ex);
        return res;
    }
}