import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2225. 합분해 / 골드5 / 23분
public class BOJ_2225 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int MOD=1_000_000_000;
    static long[][] dp=new long[201][201];

    public static void main(String[] args)throws IOException {
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        Arrays.fill(dp[0],1);
        for(int i=1;i<=m;i++){
            dp[1][i]=i;
        }
        for(int i=2;i<=n;i++){
            dp[i][1]=1;
            dp[i][2]=i+1L;
        }
        for(int i=2;i<=n;i++){
            for(int j=3;j<=m;j++){
                for(int k=i;k>=0;k--){
                    dp[i][j]+=dp[k][j-1];
                    dp[i][j]%=MOD;
                }
            }
        }
        System.out.println(dp[n][m]%MOD);
    }
}
