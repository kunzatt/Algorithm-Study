import java.io.*;
import java.util.*;

// 점화식에 대한 힌트를 검색으로 살짝 얻음
public class Main_12852 {
	
	// N이 10인 경우 nums[10] = 9가 되고 nums[9] = 3이 된다.
	// 계속 1이 될때까지 반
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[N+1]; //최소 횟수 저장
        int[] nums = new int[N+1]; //최소 경로 저장(큰 수부터 추적한다)

        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            nums[i] = i-1;
            
            if (i % 3 == 0 && dp[i/3] + 1 < dp[i]) {
                dp[i] = dp[i/3] + 1;
                nums[i] = i/3;
            }
            if (i % 2 == 0 && dp[i/2] + 1 < dp[i]) {
                dp[i] = dp[i/2] + 1;
                nums[i] = i/2;
            }
        }
        System.out.println(dp[N]);        
       
        while (N > 0) {
        	sb.append(N+" ");
            N = nums[N];
        }
        System.out.print(sb);
    }
}