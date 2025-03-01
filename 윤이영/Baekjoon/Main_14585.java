import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14585 {
    static int N, M;
    static int[][] dp = new int[301][301];
    static boolean[][] map = new boolean[301][301];
    static int ans = -100;

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
        }

        for(int r = 0; r<=300; r++){
            for(int c=0; c<=300; c++){
                if(r==0 && c == 0) continue;
                if(map[r][c]){
                    if(r == 0){
                        dp[r][c] = dp[r][c-1] + (M-r-c);
                    }else if(c == 0){
                        dp[r][c] = dp[r-1][c] + (M-r-c);
                    }
                    else {
                        dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]) + (M-r-c);
                    }
                }
                else{
                    // 사탕이 없는 경우
                    if(r == 0){
                        dp[r][c] = dp[r][c-1];
                    }else if(c == 0){
                        dp[r][c] = dp[r-1][c];
                    }
                    else {
                        dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                    }
                }
                ans = Math.max(ans, dp[r][c]);
                if((M-r-c) < 0){
                    break;
                }
                }
        }
        System.out.println(ans);
    }
}
