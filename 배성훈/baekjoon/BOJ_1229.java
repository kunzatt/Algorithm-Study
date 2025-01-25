import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// [BOJ] 육각수 / 골드 4 / 37분
public class BOJ_1229 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> six=new ArrayList<>();
    static int[] dp=new int[1111111];

    public static void main(String[] args)throws IOException {
        Arrays.fill(dp,1111111);
        int num=1;
        int digit=5;
        while(num<=1111111){
            dp[num]=1;
            six.add(num);
            num+=digit;
            digit+=4;
        }
        int n=Integer.parseInt(br.readLine());
        for(int i=2;i<=n;i++){
            for(int j=0;j<six.size();j++){
                if(i<six.get(j))break;
                dp[i]=Math.min(dp[i],dp[six.get(j)]+dp[i-six.get(j)]);
            }
        }
        System.out.println(dp[n]);
    }
}
