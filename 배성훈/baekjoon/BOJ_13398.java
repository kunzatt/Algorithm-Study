import java.io.*;

// 13398. 연속합 2 / 골드5 / 23분
public class BOJ_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        String[] input=br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i]=Integer.parseInt(input[i]);
        }
        long[][] dp=new long[n][2];
        dp[0][0]=arr[0];
        dp[0][1]=0;
        long result=dp[0][0];
        for(int i=1;i<n;i++) {
            dp[i][0]=Math.max(dp[i-1][0]+arr[i],arr[i]);
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]+arr[i]);
            result=Math.max(result,Math.max(dp[i][0],dp[i][1]));
        }
        System.out.println(result);
    }
}